package java;

public class LoadHomepageOutputData {
    // collection for all experiments
    private Object[] experiments;
    private Object[] myExperiments;
    private User user;
    // do we need username and password?

    // collection for your experiments

    //is this one really necessary
    private final boolean useCaseFailed;
    public LoadHomepageOutputData(Object[] experiments, Object[] myExperiments, User user, boolean useCaseFailed) {
        this.experiments = experiments;
        this.myExperiments = myExperiments;
        this.user = user;
        this.useCaseFailed = useCaseFailed;
    }

    public Object[] getExperiments() {
        return experiments;
    }

    public Object[] getMyExperiments() {
        return myExperiments;
    }

    public User getUser() {
        return user;
    }
}
