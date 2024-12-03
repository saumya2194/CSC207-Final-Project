package use_case.editStudy;

import entity.CommonStudy;
import entity.Study;
import entity.StudyFactory;
import use_case.createstudy.CreateStudyInputData;
import use_case.createstudy.CreateStudyOutputData;
import use_case.load_homepage.LoadHomepageExperimentsDataAccessInterface;

/**
 * The editStudy Interactor.
 */


public class EditStudyInteractor implements EditStudyInputBoundary {
    private final EditStudyDataAccessInterface experimentDAO;
    private final EditStudyOutputBoundary editStudyPresenter;
    private final StudyFactory studyFactory;



    public EditStudyInteractor(EditStudyDataAccessInterface experimentDAO, EditStudyOutputBoundary editStudyPresenter,
                               StudyFactory studyFactory) {
        this.experimentDAO = experimentDAO;
        this.editStudyPresenter = editStudyPresenter;
        this.studyFactory = studyFactory;
    }

    @Override
    public void execute(EditStudyInputData editStudyInputData) {

        final int maxCharLength = 250;
        if (editStudyInputData.getDetails().length() > maxCharLength) {
            editStudyPresenter.prepareFailView("Length has exceeded the maximum allowed characters (250).");
        }
        else {
            final CommonStudy study = studyFactory.create(editStudyInputData.getUser(), editStudyInputData.getTitle(),
                    editStudyInputData.getDetails(), editStudyInputData.getId());
            System.out.println(study.getTitle());
            experimentDAO.editResearchStudy(study);

            final EditStudyOutputData editStudyOutputData = new EditStudyOutputData(study.getTitle(),
                    study.getDetails(), false);

            editStudyPresenter.prepareSuccessView(editStudyOutputData);


        }
//        CommonStudy newstudy = editStudyInputData.getNewStudy();
//        if (!experimentDAO.editStudy(newstudy)) {
//            temp.prepareFailView("This edit was not successful!");
//        }
//        else {
//            temp.prepareSuccessView("successful edit!");
    }


    @Override
    public void switchToHomepageView() {
        editStudyPresenter.switchToHomepageView();
    }
}
