package use_case.load_homepage;

public interface LoadHomepageOutputBoundary {

    void prepareSuccessView(LoadHomepageOutputData outputData);


    void prepareFailView(String errorMessage);

    void switchToProfileView(String username);

    void switchToCreateStudyView();

    void switchToEditExperimentView(String data);

    void switchToViewExperimentView(String data);
}
