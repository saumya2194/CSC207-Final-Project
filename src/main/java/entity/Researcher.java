package entity;

public class Researcher implements User{

    private final String name;
    private final String password;
    private final String type;

    public Researcher(String name, String password) {
        this.name = name;
        this.password = password;
        this.type = "Researcher";
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