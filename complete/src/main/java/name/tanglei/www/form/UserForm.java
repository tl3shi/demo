package name.tanglei.www.form;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import name.tanglei.www.validator.CustomParam;

/**
 * @author tanglei
 * @date 2020/5/10
 */
public class UserForm {
    @Min(value = 0, message = "validate.userform.age")
    @Max(value = 120, message = "validate.userform.age")
    private int age;

    @NotNull(message = "validate.userform.name.notEmpty")
    private String name;

    @CustomParam(message = "validate.userform.param.custom")
    private String param;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParam() {
        return param;
    }

    public void setParam(String param) {
        this.param = param;
    }
}
