package java.use_case.load_homepage;

public interface LoadHomepageInputBoundry {

    void execute(LoadHomepageInputData loadHomepageInputData);

    void switchToViewProfileView();

    void switchToCreateExperimentView();

    void switchToLogoutView();
}