package use_case.load_homepage;

public interface LoadHomepageInputBoundary {

    /**
     * Execute the Load Homepage Use Case.
     * @param loadHomepageInputData the input data for this use case
     */
    void execute(LoadHomepageInputData loadHomepageInputData);

    void switchToProfileView(String username);

    void switchToCreateStudyView();

    void switchToEditExperimentView(String data);

    void switchToViewExperimentView(String data);


}