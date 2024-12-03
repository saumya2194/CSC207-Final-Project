package use_case.edit_profile;

/**
 * The Change Password Use Case.
 */
public interface EditProfileInputBoundary {

    /**
     * Execute the Change Password Use Case.
     * @param editProfileInputData the input data for this use case
     */
    void execute(EditProfileInputData editProfileInputData);

    /**
     * Executes the switch to login view use case.
     */
    void switchToHomepageView();
}
