package use_case.view_profile;

/**
 * The Change Password Use Case.
 */
public interface EditProfileInputBoundary {

    /**
     * Execute the Change Password Use Case.
     * @param editProfileInputData the input data for this use case
     */
    void execute(EditProfileInputData editProfileInputData);

}
