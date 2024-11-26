package java.interface_adapter.load_homepage;

import java.use_case.load_homepage.LoadHomepageOutputBoundry;
import java.use_case.load_homepage.LoadHomepageOutputData;

public class LoadHomepagePresenter implements LoadHomepageOutputBoundry {

    private final LoadHomepageViewModel loadHomepageViewModel;
    private final ViewProfileViewModel;
    private final CreateExperimentViewModel;
    private final EditExperimentViewModel;
    private final ViewExperimentViewModel;
    private final LoginViewModel;
    private ViewManagerModel viewManagerModel;

    public LoadHomepagePresenter(ViewManagerModel viewManagerModel, ...) {
        this.viewManagerModel = viewManagerModel;
        ...
    }

    @Override
    public void prepareSuccessView(LoadHomepageOutputData response){
        // On success, load homepage

    }

    @Override
    public void prepareFailView(String error){

    }

    public void switchToViewProfileView(){
        viewManagerModel.setState(viewProfileViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }

    // fill in the other switch things
    void switchToCreateExperimentView();

    void switchToLogoutView();


}
