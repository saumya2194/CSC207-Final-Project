package use_case.view_profile;

/**
 * The input data for the Change Password Use Case.
 */
public class EditProfileInputData {

    private final String password;
    private final String username;

    public EditProfileInputData(String password, String username) {
        this.password = password;
        this.username = username;
    }

    String getPassword() {
        return password;
    }

    String getUsername() {
        return username;
    }

}
