package java;

public interface LoadHomepageOutputBoundry {

    void prepareSuccessView(LoadHompageOutputData outputData);


    void prepareFailView(String errorMessage);
}
