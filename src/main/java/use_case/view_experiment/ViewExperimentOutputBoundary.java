package use_case.view_experiment;

public interface ViewExperimentOutputBoundary {
    void prepareSuccessView(ViewExperimentOutputData viewExperimentOutputData);
    void prepareFailView(String errormessage);
}
