package interface_adapter.createstudy;

import use_case.createstudy.CreateStudyInputBoundary;
import use_case.createstudy.CreateStudyInputData;

/**
 * The controller for the Create Study Use Case.
 */
public class CreateStudyController {

    private final CreateStudyInputBoundary createStudyUseCaseInteractor;

    public CreateStudyController(CreateStudyInputBoundary createStudyUseCaseInteractor) {
        this.createStudyUseCaseInteractor = createStudyUseCaseInteractor;
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

        createStudyUseCaseInteractor.execute(createStudyInputData);
    }

    /**
     * Executes the "switch to HomepageView" Use Case.
     */
    public void switchToHomepageView() {
        createStudyUseCaseInteractor.switchToHomepageView();
    }
}
