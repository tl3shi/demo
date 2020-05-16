package name.tanglei.www.validator;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;

/**
 * @author tanglei
 * @date 2020/5/10
 */
@Documented
@Constraint(validatedBy = CustomValidator.class)
@Target({FIELD, METHOD, PARAMETER, ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface CustomParam {
    String message() default "name.tanglei.www.validator.CustomArray.defaultMessage";

    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default { };

    @Documented
    @Retention(RetentionPolicy.RUNTIME)
    @Target({FIELD, METHOD, PARAMETER, ANNOTATION_TYPE})
    @interface List {
        CustomParam[] value();
    }
}
