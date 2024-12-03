package use_case.edit_profile;

import entity.User;
import entity.UserFactory;

/**
 * The Change Password Interactor.
 */
public class EditProfileInteractor implements EditProfileInputBoundary {
    private final EditProfileUserDataAccessInterface userDataAccessObject;
    private final EditProfileOutputBoundary userPresenter;
    private final UserFactory userFactory;

    public EditProfileInteractor(EditProfileUserDataAccessInterface changePasswordDataAccessInterface,
                                 EditProfileOutputBoundary editProfileOutputBoundary,
                                 UserFactory userFactory) {
        this.userDataAccessObject = changePasswordDataAccessInterface;
        this.userPresenter = editProfileOutputBoundary;
        this.userFactory = userFactory;
    }

    @Override
    public void execute(EditProfileInputData editProfileInputData) {
        final User user = userFactory.create(editProfileInputData.getUsername(),
                editProfileInputData.getPassword());
        userDataAccessObject.changePassword(user);

        final EditProfileOutputData editProfileOutputData = new EditProfileOutputData(user.getName(),
                false);
        userPresenter.prepareSuccessView(editProfileOutputData);
    }

    public void switchToHomepageView() {
        userPresenter.switchToHomepageView();
    }
}
