package entity;


public abstract class User {
    String name;
    String password;
    String email;

    public User(String name, String password, String email) {
        this.name = name;
        this.password = password;
        this.email = email;
    }

    public abstract String getName();
    public abstract String getPassword();

}