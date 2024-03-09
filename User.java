package LowLevelDesign.DesignVendingMachine;

public class User {
    private String username;
    private String password;
    private int loginAttempts;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.loginAttempts = 0;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void increaseLoginAttempts() {
        this.loginAttempts++;
    }

    public int getLoginAttempts() {
        return loginAttempts;
    }
}
