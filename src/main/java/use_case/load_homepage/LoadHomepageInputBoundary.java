package use_case.load_homepage;

/**
 * Switch to profile view.
 */
public interface LoadHomepageInputBoundary {

    /**
     * Execute.
     * @param loadHomepageInputData the input data for this use case
     */
    void execute(LoadHomepageInputData loadHomepageInputData);

    /**
     * Switch to profile view.
     * @param username the input data for this use case
     */
    void switchToProfileView(String username);

    /**
     * Switch to profile view.
     * @param username the input data for this use case
     */
    void switchToCreateStudyView(String username);

    /**
     * Switch to edit experiment view.
     * @param username the input data for this use case
     */
    void switchToEditExperimentView(String username);

    /**
     * Switch to EnterID view.
     * @param data String is the input data for this use case
     */
    void switchToEnterIDView(String data);


}
