package java.use_case.load_homepage;

public interface LoadHomepageOutputBoundry {

    void prepareSuccessView(LoadHomepageOutputData outputData);


    void prepareFailView(String errorMessage);

    void switchToViewProfileView();

    void switchToCreateExperimentView();

    void switchToLogoutView();
}
