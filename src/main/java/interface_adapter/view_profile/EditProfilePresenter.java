package interface_adapter.view_profile;

import interface_adapter.ViewManagerModel;
import interface_adapter.load_homepage.HomepageState;
import interface_adapter.load_homepage.HomepageViewModel;
import use_case.edit_profile.EditProfileOutputBoundary;
import use_case.edit_profile.EditProfileOutputData;

/**
 * The Presenter for the Change Password Use Case.
 */
public class EditProfilePresenter implements EditProfileOutputBoundary {
    private final HomepageViewModel homepageViewModel;
    private final ViewManagerModel viewManagerModel;

    public EditProfilePresenter(HomepageViewModel homepageViewModel, ViewManagerModel viewManagerModel) {
        this.homepageViewModel = homepageViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    @Override
    public void prepareSuccessView(EditProfileOutputData response) {
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
        // note: this use case currently can't fail
    }
}