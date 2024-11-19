package interface_adapter.Profile;
import interface_adapter.signup.ViewModel;

/**
 * The View Model for the Logged In View.
 */
public class ProfileViewModel extends ViewModel<ProfileState> {

    public ProfileViewModel() {
        super("logged in");
        setState(new ProfileState());
    }

}