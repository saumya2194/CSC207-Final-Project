package interface_adapter.view_experiment;

import interface_adapter.ViewModel;

public class ViewExperimentViewModel extends ViewModel<ViewExperimentState> {
    public static final String TITLE_LABEL ="Title:";
    public static final String DESCRIPTION_LABEL ="Description:";
    public static final String EMAIL_LABEL = "Do you want an email of the experiment details?";

    public static final String EMAIL_BUTTON_LABEL = "CLick here!";

    public ViewExperimentViewModel(String viewName) {
        super(viewName);
        setState(new ViewExperimentState());
    }
}
