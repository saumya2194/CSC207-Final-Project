package entity;

public class Participant implements User {

    private final String name;
    private final String email;
    private final String password;
    private final String type;

    public Participant(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.type = "Participant";
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getEmail() { return email; }

    @Override
    public String getType() { return type; }
}
