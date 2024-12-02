package use_case.view_experiment;

public interface ViewExperimentInputBoundary {

    void execute(ViewExperimentInputData viewExperimentInputData);

    void emailExperimentDetails(String titleText, String detailsText);
}
