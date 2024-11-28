package use_case.load_homepage;

public interface LoadHomepageInputBoundry {

    /**
     * Execute the Load Homepage Use Case.
     * @param LoadHomepageInputData the input data for this use case
     */
    void execute(LoadHomepageInputData loadHomepageInputData);

    void switchToViewProfileView();

    void switchToCreateExperimentView();

    void switchToLogoutView();
}