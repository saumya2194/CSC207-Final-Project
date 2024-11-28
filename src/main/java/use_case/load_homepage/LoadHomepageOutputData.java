package java.use_case.load_homepage;

public class LoadHomepageOutputData {
    // collection for all experiments
    private Object[] experiments;
    private Object[] myExperiments;
    private CommonUser user;
    // do we need username and password?

    // collection for your experiments

    //is this one really necessary
    private final boolean useCaseFailed;
    public LoadHomepageOutputData(Object[] experiments, Object[] myExperiments, CommonUser user, boolean useCaseFailed) {
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

    public CommonUser getUser() {
        return user;
    }
}
