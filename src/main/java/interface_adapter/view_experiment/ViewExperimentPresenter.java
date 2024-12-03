package interface_adapter.view_experiment;

import use_case.view_experiment.ViewExperimentOutputBoundary;
import use_case.view_experiment.ViewExperimentOutputData;
import interface_adapter.ViewManagerModel;

public class ViewExperimentPresenter implements ViewExperimentOutputBoundary {
    private final ViewExperimentViewModel viewExperimentViewModel;
    private final ViewManagerModel viewManagerModel;

    public ViewExperimentPresenter(ViewExperimentViewModel viewExperimentViewModel,
                                   ViewManagerModel viewManagerModel){
        this.viewExperimentViewModel = viewExperimentViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    @Override
    public void prepareSuccessView(ViewExperimentOutputData viewExperimentOutputData) {
        this.viewManagerModel.firePropertyChanged("experiment");

    }

    @Override
    public void prepareFailView(String errormessage) {
        final ViewExperimentState viewExperimentState = viewExperimentViewModel.getState();
        viewExperimentState.setViewExperimentError(errormessage);
        viewExperimentViewModel.firePropertyChanged();

    }

}
