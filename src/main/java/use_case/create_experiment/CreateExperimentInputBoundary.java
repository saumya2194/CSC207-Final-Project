package use_case.create_experiment;

/**
 * Input Boundary for actions which are related to logging in.
 */
public interface CreateExperimentInputBoundary {
    /**
     * Executes the login use case.
     * @param createExperimentInputData the input data
     */
    void execute(CreateExperimentInputData createExperimentInputData);

}
