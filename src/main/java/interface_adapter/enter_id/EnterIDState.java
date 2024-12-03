package interface_adapter.enter_id;

public class EnterIDState {
    private String id;
    private String username;

    public void setUsername(String username) {
        this.username = username;
    }
    public String getUsername() {return username;}

    public void setId(String id) {
        this.id = id;
    }
    public String getId() {return id;}
}
