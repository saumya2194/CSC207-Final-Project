package interface_adapter.load_homepage;

public class HomepageState {

    private Object[][] experiments = new Object[];
    private Object[][] myExperiments = new Object[];
    private CommonUser user;
    private String username;

    public Object[][] getExperiments() {
        return experiments;
    }

    public void setExperiments(Object[][] experiments) {
        this.experiments = experiments;
    }

    public Object[][] getMyExperiments() {
        return myExperiments;
    }

    public void setMyExperiments(Object[][] myExperiments) {
        this.myExperiments = myExperiments;
    }

    public CommonUser getUser() {
        return user;
    }

    public void setUser(CommonUser user) {
        this.user = user;
    }

    public String getUsername() {return this.username;}

    public void setUsername(String username) {this.username = username;}



}
