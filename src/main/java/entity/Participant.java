package entity;

public class Participant implements User {

    private final String name;
    private final String password;
    private final String type;

    public Participant(String name, String password) {
        this.name = name;
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
    public String getType() { return type; }
}
