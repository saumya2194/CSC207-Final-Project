package use_case.edit_profile;
/**
 * The output boundary for the Change Password Use Case.
 */
public interface EditProfileOutputBoundary {
    /**
     * Prepares the success view for the Change Password Use Case.
     * @param outputData the output data
     */
    void prepareSuccessView(EditProfileOutputData outputData);

    /**
     * Prepares the failure view for the Change Password Use Case.
     * @param errorMessage the explanation of the failure
     */
    void prepareFailView(String errorMessage);

    /**
     * Executes the switch to Homepage use case.
     */
    void switchToHomepageView();
}
