package use_case.load_homepage;

import entity.CommonStudy;

/**
 * Load homepage output data.
 */
public class LoadHomepageOutputData {
    // collection for all experiments
    private CommonStudy[] experiments;
    private CommonStudy[] myExperiments;
    private String user;

    // collection for your experiments

    private final boolean useCaseFailed;

    /**
     * The switch to edit experiment view.
     * @param experiments input
     * @param myExperiments input
     * @param user input
     * @param useCaseFailed input
     */
    public LoadHomepageOutputData(CommonStudy[] experiments, CommonStudy[] myExperiments, String user, boolean useCaseFailed) {
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

    public boolean isUseCaseFailed() { return useCaseFailed; }
}
