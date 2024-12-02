package use_case.load_homepage;
import use_case.load_homepage.LoadHomepageOutputData;
public interface LoadHomepageOutputBoundry {

    void prepareSuccessView(LoadHomepageOutputData outputData);


    void prepareFailView(String errorMessage);

    void switchToProfileView();

    void switchToCreateStudyView();


    void switchToEditExperimentView(String data);

    void switchToViewExperimentView(String data);
}
