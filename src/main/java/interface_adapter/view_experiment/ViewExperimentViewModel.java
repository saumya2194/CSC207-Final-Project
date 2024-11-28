package interface_adapter.view_experiment;

import interface_adapter.ViewModel;

public class ViewExperimentViewModel extends ViewModel<ViewExperimentState> {
    public ViewExperimentViewModel(String viewName) {
        super(viewName);
        setState(new ViewExperimentState());
    }
}
