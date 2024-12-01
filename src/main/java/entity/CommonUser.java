package entity;

/**
 * A simple implementation of the User interface.
 */
public class CommonUser implements User {

    private final String userName;
    private final String password;

    public CommonUser(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    @Override
    public String getName() {
        return userName;
    }

    @Override
    public String getPassword() {
        return password;
    }
}
