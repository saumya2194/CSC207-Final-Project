package java.interface_adapter.load_homepage;

import java.use_case.load_homepage.LoadHomepageOutputBoundry;
import java.use_case.load_homepage.LoadHomepageOutputData;

public class LoadHomepagePresenter implements LoadHomepageOutputBoundry {

    private final LoadHomepageViewModel loadHomepageViewModel;
    private final ViewProfileViewModel viewProfileViewModel;
    private final CreateExperimentViewModel createExperimentViewModel;
    private final EditExperimentViewModel editExperimentViewModel;
    private final ViewExperimentViewModel viewExperimentViewModel;
    private final LoginViewModel loginViewModel;
    private ViewManagerModel viewManagerModel;

    public LoadHomepagePresenter(ViewManagerModel viewManagerModel,
                                 ViewProfileViewModel viewProfileViewModel,
                                 CreateExperimentViewModel createExperimentViewModel,
                                 EditExperimentViewModel editExperimentViewModel,
                                 LoginViewModel loginViewModel
                                 LoadHomepageViewModel loadHomepageViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.viewProfileViewModel = viewProfileViewModel;
        this.createExperimentViewModel = createExperimentViewModel;
        this.editExperimentViewModel = editExperimentViewModel;
        this.loginViewModel = loginViewModel;
        this.loadHomepageViewModel = loadHomepageViewModel;

        ...
    }

    @Override
    public void prepareSuccessView(LoadHomepageOutputData response){
        // On success, load homepage
        final LoadHomepageState loadhomepageState = loadHomepageViewModel.getState();
        //set stuff including aspects of the state
        loadhomepageState.setExperiments(response.getExperiments());
        loadhomepageState.setMyExperiments(response.getMyExperiments());
        loadhomepageState.setUser(response.getUser());
        // do we need this?
        this.loadHomepageViewModel.setState(loadhomepageState);
        this.loadHomepageViewModel.firePropertyChanged();

        this.viewManagerModel.setState(loadHomepageViewModel.getViewName());
        this.viewManagerModel.firePropertyChanged();



    }

    @Override
    public void prepareFailView(String error){

    }

    public void switchToViewProfileView(){
        viewManagerModel.setState(viewProfileViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }

    // fill in the other switch things
    public void switchToCreateExperimentView(){
        viewManagerModel.setState(createExperimentViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }

    // wait actually TODO what is going to go on with logout
    public void switchToLogoutView(){
        viewManagerModel.setState(loginViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }


}
