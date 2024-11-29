package use_case.view_profile;

/**
 * Output Data for the Change Password Use Case.
 */
public class ViewProfileOutputData {

    private final String username;

    private final boolean useCaseFailed;

    public ViewProfileOutputData(String username, boolean useCaseFailed) {
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
