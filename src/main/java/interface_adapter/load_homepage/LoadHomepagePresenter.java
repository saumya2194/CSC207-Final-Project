package interface_adapter.load_homepage;
import entity.CommonStudy;
import interface_adapter.ViewManagerModel;
import interface_adapter.createstudy.CreateStudyViewModel;
import interface_adapter.load_homepage.HomepageState;
import interface_adapter.load_homepage.HomepageViewModel;
import interface_adapter.login.LoginViewModel;
import interface_adapter.view_experiment.ViewExperimentViewModel;
import interface_adapter.view_profile.ProfileViewModel;

import use_case.load_homepage.LoadHomepageOutputBoundry;
import use_case.load_homepage.LoadHomepageOutputData;

public class LoadHomepagePresenter implements LoadHomepageOutputBoundry {

    private final HomepageViewModel homepageViewModel;
    private final ProfileViewModel profileViewModel;
    private final CreateStudyViewModel createStudyViewModel;
    private final EditExperimentViewModel editExperimentViewModel;
    private final ViewExperimentViewModel viewExperimentViewModel;
    private final LoginViewModel loginViewModel;
    private ViewManagerModel viewManagerModel;

    public LoadHomepagePresenter(ViewManagerModel viewManagerModel,
                                 ProfileViewModel profileViewModel,
                                 CreateStudyViewModel createStudyViewModel,
                                 EditExperimentViewModel editExperimentViewModel,
                                 LoginViewModel loginViewModel,
                                 HomepageViewModel homepageViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.profileViewModel = profileViewModel;
        this.createStudyViewModel = createStudyViewModel;
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
            studyInfo[0] = study.getId();
            studyInfo[1] = study.getTitle();
            experimentsStrings += studyInfo;
        }
        Object[][] myExperimentsStrings = new Object[myExperiments.length][2];
        for (CommonStudy study : myExperiments){
            Object[] studyInfo = new Object[];
            studyInfo[0] = study.getId();
            studyInfo[1] = study.getTitle();
            myExperimentsStrings += studyInfo;
        }

        final HomepageState homepageState = homepageViewModel.getState();
        //set stuff including aspects of the state
        homepageState.setExperiments(experimentsStrings);
        homepageState.setMyExperiments(myExperimentsStrings);
        homepageState.setUser(response.getUser());
        homepageState.setUsername(response.getUser().getName());
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

    public void switchToProfileView(){
        viewManagerModel.setState(profileViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }

    // fill in the other switch things
    public void switchToCreateStudyView(){
        viewManagerModel.setState(createStudyViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }




}
