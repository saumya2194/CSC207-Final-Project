package interface_adapter.EditStudy;

import entity.CommonStudy;
import use_case.editStudy.EditStudyInputBoundary;
import use_case.editStudy.EditStudyInputData;

/**
 *  The controller for the EditStudy useCase.
 */

public class EditStudyController {
    private final EditStudyInputBoundary EditStudyUseCaseInteractor;

    public EditStudyController(EditStudyInputBoundary EditStudyInteractor) {
        this.EditStudyUseCaseInteractor = EditStudyInteractor;
    }
    /**
     *
     */
    public void execute(CommonStudy newStudy) {
        final EditStudyInputData input = new EditStudyInputData(newStudy);
        EditStudyUseCaseInteractor.execute(input);
    }


}
