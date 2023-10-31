package javaassignment;

public class User {
    private String userId;
    private String password;
    private double balance;

    public User() {
        // Default constructor
    }

    public User(String userId, String password, double balance) {
        this.userId = userId;
        this.password = password;
        this.balance = balance;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", password='" + password + '\'' +
                ", balance=" + balance +
                '}';
    }
}
