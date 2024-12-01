package interface_adapter.load_homepage;

import entity.CommonStudy;
import interface_adapter.ViewModel;
import interface_adapter.load_homepage.HomepageState;

public class HomepageViewModel extends ViewModel<HomepageState> {
    public static final String TITLE_LABEL = "Homepage" ;
    public static final String CREATE_EXPERIMENT_BUTTON_LABEL = "Create Experiment";
    public static final String PROFILE_BUTTON_LABEL = "Profile";
    public static final CommonStudy[] myExperimentsColumns = {"ID", "Name"};
    public static final CommonStudy[] experimentsColumns = {"ID", "Name"};
    public static final String EXPERIMENTS_TITLE_LABEL = "Experiments";
    public static final String MY_EXPERIMENTS_TITLE_LABEL = "My Experiments";


    public HomepageViewModel(){
        super("load homepage");
        setState(new HomepageState());
    }

}
