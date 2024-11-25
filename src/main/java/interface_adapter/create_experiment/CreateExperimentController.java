package interface_adapter.create_experiment;

import use_case.create_experiment.CreateExperimentInputBoundary;
import use_case.create_experiment.CreateExperimentInputData;

/**
 * The controller for the Create Experiment Use Case.
 */
public class CreateExperimentController {

    private final CreateExperimentInputBoundary createExperimentUseCaseInteractor;

    public CreateExperimentController(CreateExperimentInputBoundary createExperimentUseCaseInteractor) {
        this.createExperimentUseCaseInteractor = createExperimentUseCaseInteractor;
    }

    /**
     * Executes the Create Experiment Use Case.
     * @param title the title of the experiment/study
     * @param details the details of experiment
     */
    public void execute(String title, String details) {
        final CreateExperimentInputData createExperimentInputData = new CreateExperimentInputData(
                title, details, );
        //TODO add current user method

        createExperimentUseCaseInteractor.execute(createExperimentInputData);
    }
}
