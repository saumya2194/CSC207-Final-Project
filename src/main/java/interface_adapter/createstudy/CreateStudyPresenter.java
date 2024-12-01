package interface_adapter.createstudy;

import interface_adapter.ViewManagerModel;
import interface_adapter.homepage.HomepageState;
import interface_adapter.homepage.HompageViewModel;
import interface_adapter.signup.ViewManagerModel;
import use_case.createstudy.CreateStudyOutputBoundary;
import use_case.createstudy.CreateStudyOutputData;

/**
 * The Presenter for the Create Study Use Case.
 */
public class CreateStudyPresenter implements CreateStudyOutputBoundary{

    private final CreateStudyViewModel createStudyViewModel;

    private final HomepageViewModel homepageViewModel;
    private final ViewManagerModel viewManagerViewModel;

    public CreateStudyPresenter(ViewManagerModel viewManagerModel,
                                HomepageViewModel homepageViewModel,
                                CreateStudyViewModel createStudyViewModel) {
        this.viewManagerViewModel = viewManagerModel;
        this.createStudyViewModel = createStudyViewModel;
        this.homepageViewModel = homepageViewModel;
    }




    @Override
    public void prepareSuccessView(CreateStudyOutputData response) {
        // On success, switch to the homepage view.
        final HomepageState homepageState = homepageViewModel.getState();
        hompageState.setUsername(response.getUsername());
        this.loginViewModel.setState(loginState);
        loginViewModel.firePropertyChanged();

        viewManagerModel.setState(loginViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String error) {
        final SignupState signupState = signupViewModel.getState();
        signupState.setUsernameError(error);
        signupViewModel.firePropertyChanged();
    }

    @Override
    public void switchToLoginView() {
        viewManagerModel.setState(loginViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }
}
