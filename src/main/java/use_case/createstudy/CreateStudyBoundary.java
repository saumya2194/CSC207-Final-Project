package use_case.createstudy;

/**
 * Input Boundary for actions which are related to creating a study.
 */
public interface CreateStudyBoundary {
    /**
     * Executes the login use case.
     * @param createStudyInputData the input data
     */
    void execute(CreateStudyInputData createStudyInputData);

}
