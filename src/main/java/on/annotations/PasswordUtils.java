package on.annotations;

public class PasswordUtils {

    @UseCase(id = 47, desc = "密码必须包含至少一个数字")
    public boolean validatePassword(String pwd) {
        return (pwd.matches("\\w*\\d\\w*"));
    }

    @UseCase(id = 48)
    public String encryptPassword(String pwd) {
        return new StringBuilder(pwd).reverse().toString();
    }

    @UseCase(id = 49, desc = "两次密码不能相同")
    public boolean checkForNewPassword(String pwdOld, String pwdNew) {
        return !pwdOld.equals(pwdNew);
    }
}
