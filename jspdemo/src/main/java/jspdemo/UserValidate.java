package jspdemo;

public class UserValidate {
    public boolean isValidUser(String userName, String password) {
        return userName.equals("tester") && password.equals("tester");
    }
}
