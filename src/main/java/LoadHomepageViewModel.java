package java;

public class LoadHomepageViewModel extends ViewModel<LoadHomepageState> {
    public static final String TITLE_LABEL = "Homepage" ;
    public static final String CREATE_EXPERIMENT_BUTTON_LABEL = "Create Experiment";
    public int myExperimentsData;

    public SignupViewModel(){
        super("load homepage");
        setState(new LoadHomepageState());
    }

}
