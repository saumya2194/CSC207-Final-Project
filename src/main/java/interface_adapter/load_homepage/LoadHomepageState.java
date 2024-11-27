package java.interface_adapter.load_homepage;

public class LoadHomepageState {

    private Object[] experiments = new Object[];
    private Object[] myExperiments = new Object[];
    private User user;

    public Object[] getExperiments() {
        return experiments;
    }

    public void setExperiments(Object[] experiments) {
        this.experiments = experiments;
    }

    public Object[] getMyExperiments() {
        return myExperiments;
    }

    public void setMyExperiments(Object[] myExperiments) {
        this.myExperiments = myExperiments;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
