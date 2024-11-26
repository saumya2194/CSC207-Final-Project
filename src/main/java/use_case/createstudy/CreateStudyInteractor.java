package use_case.createstudy;

import data_access.DBExperimentDataAccessObject;
import entity.StudyFactory;
import entity.User;
import entity.UserFactory;


/**
* The Create Study Interactor.
 */
public class CreateStudyInteractor {

    private final CreateStudyDataAccessInterface studyDataAcessObject;
    private final CreateStudyOutputBoundary  studyPresenter;
    private final StudyFactory studyFactory;

    public CreateStudyInteractor(CreateStudyDataAccessInterface createStudyDataAccessInterface,
                                 CreateStudyOutputBoundary createStudyOutputBoundary,
                                 StudyFactory studyFactory) {
        this.studyDataAcessObject = createStudyDataAccessInterface;
        this.studyPresenter = createStudyOutputBoundary;
        this.studyFactory = studyFactory;

    @Override
    public void execute(CreateStudyInputData createStudyInputData) {
        if (createStudyInputDada.getDetails)
        }

    @Override
    public void execute(SignupInputData signupInputData) {
        if (userDataAccessObject.existsByName(signupInputData.getUsername())) {
            userPresenter.prepareFailView("User already exists.");
        }
        else if (!signupInputData.getPassword().equals(signupInputData.getRepeatPassword())) {
            userPresenter.prepareFailView("Passwords don't match.");
        }
        else {
            final User user = userFactory.create(signupInputData.getUsername(), signupInputData.getPassword());
            userDataAccessObject.save(user);

            final SignupOutputData signupOutputData = new SignupOutputData(user.getName(), false);
            userPresenter.prepareSuccessView(signupOutputData);
        }
    }

    @Override
    public void switchToLoginView() {
        userPresenter.switchToLoginView();
    }
}

}
