package name.tanglei.www;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolationException;

import name.tanglei.www.exception.BadRequestException;
import name.tanglei.www.utils.LanguaggeUtils;
import name.tanglei.www.vo.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author tanglei
 * @date 2020/5/10
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    @Autowired
    private MessageSource messageSource;

    @ExceptionHandler(BadRequestException.class)
    @ResponseBody
    public ResponseEntity handle(HttpServletRequest request, BadRequestException e){
        String i18message = getI18nMessage(e.getKey(), request);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Response.error(e.getCode(), i18message));
    }

    @ExceptionHandler(BindException.class)
    @ResponseBody
    public ResponseEntity handle(HttpServletRequest request, BindException e){
        String key = e.getBindingResult().getAllErrors().get(0).getDefaultMessage();
        String i18message = getI18nMessage(key, request);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Response.error(400, i18message));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public ResponseEntity handle(HttpServletRequest request, MethodArgumentNotValidException e){
        String key = e.getBindingResult().getAllErrors().get(0).getDefaultMessage();
        String i18message = getI18nMessage(key, request);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Response.error(400, i18message));
    }

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseBody
    public ResponseEntity handle(HttpServletRequest request, ConstraintViolationException e){
        String key = e.getConstraintViolations().iterator().next().getMessage();
        String i18message = getI18nMessage(key, request);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Response.error(400, i18message));
    }

    @ExceptionHandler(Throwable.class)
    @ResponseBody
    public ResponseEntity handle(HttpServletRequest request, Throwable e){
        String message = e.getMessage();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Response.error(500, message));
    }

    private String getI18nMessage(String key, HttpServletRequest request) {
        try {
            return messageSource.getMessage(key, null, LanguaggeUtils.currentLocale(request));
        } catch (Exception e) {
            // log
            return key;
        }
    }
}
