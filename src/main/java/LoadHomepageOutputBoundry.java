package java;

public interface LoadHomepageOutputBoundry {

    void prepareSuccessView(LoadHomepageOutputData outputData);


    void prepareFailView(String errorMessage);

    void switchToViewProfileView();

    void switchToCreateExperimentView();

    void switchToLogoutView();
}
