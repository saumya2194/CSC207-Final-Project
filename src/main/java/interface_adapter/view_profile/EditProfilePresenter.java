package interface_adapter.view_profile;

import use_case.view_profile.EditProfileOutputBoundary;
import use_case.view_profile.EditProfileOutputData;

/**
 * The Presenter for the Change Password Use Case.
 */
public class EditProfilePresenter implements EditProfileOutputBoundary {

    private final ProfileViewModel profileViewModel;

    public EditProfilePresenter(ProfileViewModel profileViewModel) {
        this.profileViewModel = profileViewModel;
    }

    @Override
    public void prepareSuccessView(EditProfileOutputData outputData) {
        // currently there isn't anything to change based on the output data,
        // since the output data only contains the username, which remains the same.
        // We still fire the property changed event, but just to let the view know that
        // it can alert the user that their password was changed successfully..
        profileViewModel.firePropertyChanged("password");

    }

    @Override
    public void prepareFailView(String error) {
        // note: this use case currently can't fail
    }
}