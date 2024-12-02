
package interface_adapter.view_profile;

import interface_adapter.ViewModel;

/**
 * The View Model for the Logged In View.
 */
public class ProfileViewModel extends ViewModel<ProfileState> {

    public ProfileViewModel() {
        super("profile view");
        setState(new ProfileState());
    }

}