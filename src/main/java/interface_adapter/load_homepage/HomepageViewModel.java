package interface_adapter.load_homepage;

import data_access.DBExperimentDataAccessObject;
import entity.CommonStudy;
import entity.CommonStudyFactory;
import entity.CommonUserFactory;
import interface_adapter.ViewModel;

public class HomepageViewModel extends ViewModel<HomepageState> {
    public static final String TITLE_LABEL = "Homepage" ;
    public static final String CREATE_EXPERIMENT_BUTTON_LABEL = "Create Experiment";
    public static final String PROFILE_BUTTON_LABEL = "Profile";
    public static final String[] myExperimentsColumns = {"ID", "Name"};
    public static final String[] experimentsColumns = {"ID", "Name"};
    public static final String EXPERIMENTS_TITLE_LABEL = "Experiments";
    public static final String MY_EXPERIMENTS_TITLE_LABEL = "My Experiments";
    public static final String EDIT_EXPERIMENT_BUTTON_LABEL = "Edit Experiment";
    public static final String VIEW_EXPERIMENT_BUTTON_LABEL = "View Experiment";


    public HomepageViewModel(){
        super("homepage");
        DBExperimentDataAccessObject db = new DBExperimentDataAccessObject(new CommonStudyFactory(), new CommonUserFactory());
        HomepageState homepageState = new HomepageState();
        homepageState.setExperiments(db.getStudyObjects().toArray(new CommonStudy[0]));
        homepageState.setMyExperiments(db.retrieveUserStudies("jackypoo").toArray(new CommonStudy[0]));

        setState(homepageState);
    }

}
