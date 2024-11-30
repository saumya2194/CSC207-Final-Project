package use_case.load_homepage;
import use_case.load_homepage.LoadHomepageInputData;

public interface LoadHomepageInputBoundry {

    /**
     * Execute the Load Homepage Use Case.
     * @param loadHomepageInputData the input data for this use case
     */
    void execute(LoadHomepageInputData loadHomepageInputData);

    void switchToProfileView();

    void switchToCreateStudyView();

}