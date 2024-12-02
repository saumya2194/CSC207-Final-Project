package use_case.load_homepage;

import entity.CommonStudy;
import entity.CommonUser;

public class LoadHomepageOutputData {
    // collection for all experiments
    private Object[] experiments;
    private Object[] myExperiments;
    private String user;
    // do we need username and password?

    // collection for your experiments

    //is this one really necessary
    private final boolean useCaseFailed;
    public LoadHomepageOutputData(Object[] experiments, Object[] myExperiments, String user, boolean useCaseFailed) {
        this.experiments = experiments;
        this.myExperiments = myExperiments;
        this.user = user;
        this.useCaseFailed = useCaseFailed;
    }

    public CommonStudy[] getExperiments() {
        return experiments;
    }

    public CommonStudy[] getMyExperiments() {
        return myExperiments;
    }

    public String getUser() {
        return user;
    }
}
