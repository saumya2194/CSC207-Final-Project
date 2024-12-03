package interface_adapter.EditStudy;

import entity.CommonStudy;
import use_case.editStudy.EditStudyInputBoundary;
import use_case.editStudy.EditStudyInputData;

/**
 *  The controller for the EditStudy useCase.
 */

public class EditStudyController {
    private final EditStudyInputBoundary editStudyUseCaseInteractor;

    public EditStudyController(EditStudyInputBoundary EditStudyInteractor) {
        this.editStudyUseCaseInteractor = EditStudyInteractor;
    }
    /**
     *
     */
    public void execute(String title, String details, String user, String ID) {
        final EditStudyInputData editStudyInputData = new EditStudyInputData(
                title, details, user, ID);
        editStudyUseCaseInteractor.execute(editStudyInputData);
    }

    public void switchToHomepageView() {
        editStudyUseCaseInteractor.switchToHomepageView();
    }


}
