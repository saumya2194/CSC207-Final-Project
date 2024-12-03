package use_case.load_homepage;

/**
 * Load Homepage Output Boundry.
 */

public interface LoadHomepageOutputBoundary {

    /**
     * Prepares the success view for the load homepage Use Case.
     * @param outputData the output data
     */
    void prepareSuccessView(LoadHomepageOutputData outputData);

    /**
     * Prepares the fail view for the load homepage Use Case.
     * @param errorMessage the output data
     */
    void prepareFailView(String errorMessage);

    /**
     * Prepares the profile view for the load homepage Use Case.
     * @param username string
     */
    void switchToProfileView(String username);

    /**
     * Prepares the profile view for the load homepage Use Case.
     * @param username string
     */
    void switchToCreateStudyView(String username);

    /**
     * Prepares the edit experiment view for the load homepage Use Case.
     * @param username string
     */
    void switchToEditExperimentView(String username);

    /**
     * Prepares the enter id view for the load homepage Use Case.
     * @param data string
     */
    void switchToEnterIDView(String data);
}
