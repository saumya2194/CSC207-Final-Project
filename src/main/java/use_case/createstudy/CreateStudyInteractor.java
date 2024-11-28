package use_case.createstudy;

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
        if (createStudyInputData.getDetails().length() > 250) {
            studyPresenter.prepareFailView("Length has exceeded the maximum allowed characters (250).");
        }
        else {
            final Study study = studyFactory.create(createStudyInputData.getTitle(), createStudyInputData.getDetails(),
                    createStudyInputData.getUser());


        }
    }
    public void switchToLoginView() {
        studyPresenter.switchToLoginView();
    }
}