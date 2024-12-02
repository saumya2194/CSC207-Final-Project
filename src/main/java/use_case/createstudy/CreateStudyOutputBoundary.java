package use_case.createstudy;

/**
 * The output boundary for the Create Study Use Case.
 */
public interface CreateStudyOutputBoundary {
    /**
     * Prepares the success view for the Create Study Use Case.
     * @param outputData the output data
     */
    void prepareSuccessView(CreateStudyOutputData outputData);

    /**
     * Prepares the failure view for the Create Study Use Case.
     * @param errorMessage the explanation of the failure
     */
    void prepareFailView(String errorMessage);

    /**
     * Executes the switch to Homepage use case.
     */
    void switchToHomepageView();
}
