package interface_adapter.login;

import interface_adapter.ViewManagerModel;
import interface_adapter.homepage.HompageViewModel;
import interface_adapter.view_profile.ProfileState;
import interface_adapter.view_profile.ProfileViewModel;
import use_case.login.LoginOutputBoundary;
import use_case.login.LoginOutputData;
import interface_adapter.login.LoginState;


/**
 * The Presenter for the Login Use Case.
 */
public class LoginPresenter implements LoginOutputBoundary {

    private final LoginViewModel loginViewModel;
    private final HomepageViewModel homepageViewModel;
    private final ViewManagerModel viewManagerModel;

    public LoginPresenter(ViewManagerModel viewManagerModel,
                          LoginViewModel loginViewModel, HomepageViewModel homepageViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.homepageViewModel = homepageViewModel;
        this.loginViewModel = loginViewModel;
    }

    @Override
    public void prepareSuccessView(LoginOutputData response) {
        // On success, switch to the logged in view.

        final HomepageState homepageState = homepageViewModel.getState();
        homepageState.setUsername(response.getUsername());
        this.homepageViewModel.setState(homepageState);
        this.homepageViewModel.firePropertyChanged();

        this.viewManagerModel.setState(homepageViewModel.getViewName());
        this.viewManagerModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String error) {
        final LoginState loginState = loginViewModel.getState();
        loginState.setLoginError(error);
        loginViewModel.firePropertyChanged();
    }
}

