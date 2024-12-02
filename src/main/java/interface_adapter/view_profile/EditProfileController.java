
package interface_adapter.view_profile;


import use_case.edit_profile.EditProfileInputBoundary;
import use_case.edit_profile.EditProfileInputData;

/**
 * Controller for the Change Password Use Case.
 */
public class EditProfileController {
    private final EditProfileInputBoundary userChangePasswordUseCaseInteractor;

    public EditProfileController(EditProfileInputBoundary userChangePasswordUseCaseInteractor) {
        this.userChangePasswordUseCaseInteractor = userChangePasswordUseCaseInteractor;
    }

    /**
     * Executes the Change Password Use Case.
     * @param password the new password
     * @param username the user whose password to change
     */
    public void execute(String password, String username) {
        final EditProfileInputData editProfileInputData = new EditProfileInputData(username, password);

        userChangePasswordUseCaseInteractor.execute(editProfileInputData);
    }
}