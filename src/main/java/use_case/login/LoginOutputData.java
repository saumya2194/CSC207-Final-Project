package use_case.login;

public class LoginOutputData {

    private final String email;
    private final boolean useCaseFailed;

    public LoginOutputData(String email, boolean useCaseFailed) {
        this.email = email;
        this.useCaseFailed = useCaseFailed;
    }

    public String getEmail() {
        return email;
    }
}
