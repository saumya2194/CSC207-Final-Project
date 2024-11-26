package main.java;

public interface LoadHomepageInputBoundry {

    void execute(main.java.LoadHomepageInputData loadHomepageInputData);

    void switchToViewProfileView();

    void switchToCreateExperimentView();

    void switchToLogoutView();
}