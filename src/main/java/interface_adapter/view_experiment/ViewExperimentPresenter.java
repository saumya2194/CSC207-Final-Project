package interface_adapter.view_experiment;

import interface_adapter.load_homepage.HomepageState;
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
        final ViewExperimentState viewExperimentState = viewExperimentViewModel.getState();
        //set stuff including aspects of the state
        viewExperimentState.setId(viewExperimentOutputData.getId());
        this.viewExperimentViewModel.setState(viewExperimentState);
        this.viewExperimentViewModel.firePropertyChanged();

        this.viewManagerModel.setState(viewExperimentViewModel.getViewName());
        this.viewManagerModel.firePropertyChanged();

    }


    @Override
    public void prepareFailView(String errormessage) {
        final ViewExperimentState viewExperimentState = viewExperimentViewModel.getState();
        viewExperimentState.setViewExperimentError(errormessage);
        viewExperimentViewModel.firePropertyChanged();

    }

}
