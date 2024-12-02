package use_case.edit_profile;

/**
 * Output Data for the Change Password Use Case.
 */
public class EditProfileOutputData {

    private final String username;

    private final boolean useCaseFailed;

    public EditProfileOutputData(String username, boolean useCaseFailed) {
        this.username = username;
        this.useCaseFailed = useCaseFailed;
    }

    public String getUsername() {
        return username;
    }

    public boolean isUseCaseFailed() {
        return useCaseFailed;
    }
}
