package interface_adapter.createstudy;

import use_case.createstudy.CreateStudyInputBoundary;
import use_case.createstudy.CreateStudyInputData;

/**
 * The controller for the Create Study Use Case.
 */
public class CreateStudyController {

    private final CreateStudyInputBoundary createExperimentUseCaseInteractor;

    public CreateStudyController(CreateStudyInputBoundary createStudyUseCaseInteractor) {
        this.createExperimentUseCaseInteractor = createStudyUseCaseInteractor;
    }

    /**
     * Executes the Create Study Use Case.
     * @param title the title of the experiment/study
     * @param details the details of experiment
     * @param user email of user
     */
    public void execute(String title, String details, String user) {
        final CreateStudyInputData createStudyInputData = new CreateStudyInputData(
                title, details, user);

        createExperimentUseCaseInteractor.execute(createStudyInputData);
    }
}
