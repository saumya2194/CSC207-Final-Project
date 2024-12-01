package use_case.createstudy;

/**
 * Input Boundary for actions which are related to creating a study.
 */
public interface CreateStudyInputBoundary {
    /**
     * Executes the login use case.
     * @param createStudyInputData the input data
     */
    void execute(CreateStudyInputData createStudyInputData);

    /**
     * Executes the switch to login view use case.
     */
    void switchToHomepageView();
}
