package use_case.homepage;

public interface LoadHomepageOutputBoundry {

    void prepareSuccessView(LoadHompageOutputData outputData);


    void prepareFailView(String errorMessage);
}
