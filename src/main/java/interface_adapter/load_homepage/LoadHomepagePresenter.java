package java.interface_adapter.load_homepage;
import interface_adapter.ViewManagerModel;
import interface_adapter.load_homepage.HomepageState;
import interface_adapter.load_homepage.HomepageViewModel;

import java.use_case.load_homepage.LoadHomepageOutputBoundry;
import java.use_case.load_homepage.LoadHomepageOutputData;

public class LoadHomepagePresenter implements LoadHomepageOutputBoundry {

    private final HomepageViewModel homepageViewModel;
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
                                 HomepageViewModel homepageViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.viewProfileViewModel = viewProfileViewModel;
        this.createExperimentViewModel = createExperimentViewModel;
        this.editExperimentViewModel = editExperimentViewModel;
        this.loginViewModel = loginViewModel;
        this.homepageViewModel = homepageViewModel;


    }

    @Override
    public void prepareSuccessView(LoadHomepageOutputData response){
        // On success, load homepage
        Object[] experiments = response.getExperiments();
        Object[] myExperiments = response.getMyExperiments();

        Object[][] experimentsStrings = new Object[experiments.length][2];
        for (CommonStudy study : experiments){
            Object[] studyInfo = new Object[];
            studyInfo[0] = study.getID();
            studyInfo[1] = study.getName();
            experimentsStrings += studyInfo;
        }
        Object[][] myExperimentsStrings = new Object[myExperiments.length][2];
        for (CommonStudy study : myExperiments){
            Object[] studyInfo = new Object[];
            studyInfo[0] = study.getID();
            studyInfo[1] = study.getName();
            myExperimentsStrings += studyInfo;
        }

        final HomepageState homepageState = homepageViewModel.getState();
        //set stuff including aspects of the state
        homepageState.setExperiments(experimentsStrings);
        homepageState.setMyExperiments(myExperimentsStrings);
        homepageState.setUser(response.getUser());
        // do we need this?
        this.homepageViewModel.setState(homepageState);
        this.homepageViewModel.firePropertyChanged();

        this.viewManagerModel.setState(homepageViewModel.getViewName());
        this.viewManagerModel.firePropertyChanged();



    }

    @Override
    public void prepareFailView(String error){
        // TODO: what do I put here?
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




}
