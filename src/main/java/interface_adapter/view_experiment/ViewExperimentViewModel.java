package interface_adapter.view_experiment;

import interface_adapter.ViewModel;

public class ViewExperimentViewModel extends ViewModel<ViewExperimentState> {
    public static final String TITLE_LABEL ="Title:";
    public static final String DESCRIPTION_LABEL ="Description:";

    public ViewExperimentViewModel() {
        super("view experiment");
        setState(new ViewExperimentState());
    }
}
