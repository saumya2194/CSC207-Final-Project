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
        CommonStudy newStudy = new CommonStudy(user, title, details, ID);
//        final EditStudyInputData input = new EditStudyInputData(newStudy);
//        editStudyUseCaseInteractor.execute(input);
    }

    public void switchToHomepageView() {
        editStudyUseCaseInteractor.switchToHomepageView();
    }


}
