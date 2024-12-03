
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
        final int maxCharLength = 250;
        if (createStudyInputData.getDetails().length() > maxCharLength) {
            studyPresenter.prepareFailView("Length has exceeded the maximum allowed characters (250).");
        }
        else {
            final Study study = studyFactory.create(createStudyInputData.getUser(), createStudyInputData.getDetails(),
                    createStudyInputData.getDetails());
                studyDataAccessObject.save(study);
                System.out.println("title: " + study.getTitle());
                System.out.println("details: " +study.getDetails());
                System.out.println("user: " +study.getUser());

            final CreateStudyOutputData createStudyOutputData = new CreateStudyOutputData(study.getTitle(),
                        study.getDetails(),
                        false);
                studyPresenter.prepareSuccessView(createStudyOutputData);


        }
    }

    public void switchToHomepageView() {
        studyPresenter.switchToHomepageView();
    }
}