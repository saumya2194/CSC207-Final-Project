package use_case.editStudy;

import entity.CommonStudy;
import use_case.load_homepage.LoadHomepageExperimentsDataAccessInterface;

/**
 * The editStudy Interactor.
 */


public class EditStudyInteractor implements EditStudyInputBoundary {
    private final EditStudyDataAccessInterface experimentDAO;
    private final EditStudyOutputBoundary temp; //idk what goes here

    public EditStudyInteractor(EditStudyDataAccessInterface experimentDAO, EditStudyOutputBoundary temp) {
        this.experimentDAO = experimentDAO;
        this.temp = temp;
    }

    public void execute(EditStudyInputData editStudyInputData) {
        CommonStudy newstudy = editStudyInputData.getNewStudy();
        if (!experimentDAO.editStudy(newstudy)) {
            temp.prepareFailView("This edit was not successful!");
        }
        else {
            temp.prepareSuccessView("successful edit!");
        }

    }
}
