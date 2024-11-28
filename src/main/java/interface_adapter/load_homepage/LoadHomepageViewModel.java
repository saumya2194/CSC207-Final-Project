package java.interface_adapter.load_homepage;

import interface_adapter.load_homepage.LoadHomepageState;

public class LoadHomepageViewModel extends ViewModel<LoadHomepageState> {
    public static final String TITLE_LABEL = "Homepage" ;
    public static final String CREATE_EXPERIMENT_BUTTON_LABEL = "Create Experiment";
    public static final String PROFILE_BUTTON_LABEL = "Profile";
    public static final String LOGOUT_BUTTON_LABEL = "Logout";
    public static final Object[] myExperimentsColumns = {"ID", "Name"};
    public static final Object[] experimentsColumns = {"ID", "Name"};
    public static final String EXPERIMENTS_TITLE_LABEL = "Experiments";
    public static final String MY_EXPERIMENTS_TITLE_LABEL = "My Experiments";


    public LoadHomepageViewModel(){
        super("load homepage");
        setState(new LoadHomepageState());
    }

}
