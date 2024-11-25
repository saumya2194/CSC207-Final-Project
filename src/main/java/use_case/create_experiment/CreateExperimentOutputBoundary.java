package use_case.create_experiment;

import use_case.login.LoginOutputData;

/**
 * The output boundary for the Create Experiment Use Case.
 */
public interface CreateExperimentOutputBoundary {
    /**
     * Prepares the success view for the Create Experiment Use Case.
     * @param outputData the output data
     */
    void prepareSuccessView(LoginOutputData outputData);

    /**
     * Prepares the failure view for the Create Experiment Use Case.
     * @param errorMessage the explanation of the failure
     */
    void prepareFailView(String errorMessage);
}
