package java.interface_adapter.load_homepage;

public class LoadHomepageViewModel extends ViewModel<LoadHomepageState> {
    public static final String TITLE_LABEL = "Homepage" ;
    public static final String CREATE_EXPERIMENT_BUTTON_LABEL = "Create Experiment";
    public static final String PROFILE_BUTTON_LABEL = "Profile";
    public static final String LOGOUT_BUTTON_LABEL = "Logout";
    public static final Object[] myExperimentsColumns = {"ID", "Name"};
    public static final Object[] experimentsColumns = {"ID", "Name"};


    public LoadHomepageViewModel(){
        super("load homepage");
        setState(new LoadHomepageState());
    }

}
