package use_case.createstudy;

import data_access.DBExperimentDataAccessObject;
import entity.Study;
import entity.StudyFactory;



/**
* The Create Study Interactor.
 */
public class CreateStudyInteractor implements CreateStudyInputBoundary {

    private final CreateStudyDataAccessInterface studyDataAccessObject;
    private final CreateStudyOutputBoundary studyPresenter;
    private final StudyFactory studyFactory;

    public CreateStudyInteractor(CreateStudyDataAccessInterface createStudyDataAccessInterface,
                                 CreateStudyOutputBoundary createStudyOutputBoundary,
                                 StudyFactory studyFactory) {
        this.studyDataAccessObject = createStudyDataAccessInterface;
        this.studyPresenter = createStudyOutputBoundary;
        this.studyFactory = studyFactory;
    }

    @Override
    public void execute(CreateStudyInputData createStudyInputData) {
        final int maxCharLength = 250;
        if (createStudyInputData.getDetails().length() > maxCharLength) {
            studyPresenter.prepareFailView("Length has exceeded the maximum allowed characters (250).");
        }
        else {
            final Study study = studyFactory.create(createStudyInputData.getTitle(), createStudyInputData.getDetails(),
                    createStudyInputData.getUser());
            DBExperimentDataAccessObject.saveResearch


        }
    }
    public void switchToLoginView() {
        studyPresenter.switchToHomepageView();
    }
}