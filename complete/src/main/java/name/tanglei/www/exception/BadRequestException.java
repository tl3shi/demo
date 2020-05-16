package name.tanglei.www.exception;

/**
 * @author tanglei
 * @date 2020/5/10
 */
public class BadRequestException extends RuntimeException {
    private int code;
    private String key;

    public BadRequestException(String key) {
        this.code = 400;
        this.key = key;
    }

    public BadRequestException(int code, String key) {
        this.code = code;
        this.key = key;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

}
