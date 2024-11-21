package use_case.login;

import entity.User;

public class LoginInteractor {

    private final LoginUserDataAccessInterface userDataAccessObject;
    private final LoginOutputBoundary loginPresenter;

    public LoginInteractor(LoginUserDataAccessInterface userDataAccessInterface,
                           LoginOutputBoundary loginOutputBoundary) {
        this.userDataAccessObject = userDataAccessInterface;
        this.loginPresenter = loginOutputBoundary;
    }


    public void execute(LoginInputData loginInputData) {
        final String email = loginInputData.getEmail();
        final String password = loginInputData.getPassword();
        if (!userDataAccessObject.existsByName(email)) {
            loginPresenter.prepareFailView(email + ": Account does not exist.");
        }
        else {
            final String pwd = userDataAccessObject.get(email).getPassword();
            if (!password.equals(pwd)) {
                loginPresenter.prepareFailView("Incorrect password for \"" + email + "\".");
            }
            else {

                final User user = userDataAccessObject.get(loginInputData.getEmail());

                userDataAccessObject.setCurrentEmail(user.getName());
                final LoginOutputData loginOutputData = new LoginOutputData(user.getName(), false);
                loginPresenter.prepareSuccessView(loginOutputData);
            }
        }
    }
}
