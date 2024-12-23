package interface_adapter.load_homepage;
import interface_adapter.EditStudy.EditStudyState;
import interface_adapter.EditStudy.EditStudyViewModel;
import interface_adapter.ViewManagerModel;
import interface_adapter.createstudy.CreateStudyViewModel;
import interface_adapter.enter_id.EnterIDState;
import interface_adapter.enter_id.EnterIDViewModel;
import interface_adapter.view_profile.ProfileState;
import interface_adapter.view_profile.ProfileViewModel;

import use_case.load_homepage.LoadHomepageOutputBoundary;
import use_case.load_homepage.LoadHomepageOutputData;

public class LoadHomepagePresenter implements LoadHomepageOutputBoundary {

    private final HomepageViewModel homepageViewModel;
    private final ProfileViewModel profileViewModel;
    private final CreateStudyViewModel createStudyViewModel;
    private final EditStudyViewModel editStudyViewModel;
    private final EnterIDViewModel enterIDViewModel;
    private ViewManagerModel viewManagerModel;

    public LoadHomepagePresenter(ViewManagerModel viewManagerModel,
                                 ProfileViewModel profileViewModel,
                                 CreateStudyViewModel createStudyViewModel,
                                 EditStudyViewModel editStudyViewModel,
                                 EnterIDViewModel enterIDViewModel,
                                 HomepageViewModel homepageViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.profileViewModel = profileViewModel;
        this.createStudyViewModel = createStudyViewModel;
        this.editStudyViewModel = editStudyViewModel;
        this.enterIDViewModel = enterIDViewModel;
        this.homepageViewModel = homepageViewModel;


    }

    @Override
    public void prepareSuccessView(LoadHomepageOutputData response){
        final HomepageState homepageState = homepageViewModel.getState();
        //set stuff including aspects of the state
        homepageState.setExperiments(response.getExperiments());
        homepageState.setMyExperiments(response.getMyExperiments());
        homepageState.setUsername(response.getUser());
        // do we need this?
        this.homepageViewModel.setState(homepageState);
        this.homepageViewModel.firePropertyChanged();

        this.viewManagerModel.setState(homepageViewModel.getViewName());
        this.viewManagerModel.firePropertyChanged();

    }

    @Override
    public void prepareFailView(String error){
       //Should never fail
    }

    public void switchToProfileView(String username){
        // Get the current state of the ProfileViewModel

        final ProfileState profileState = profileViewModel.getState();
        profileState.setUsername(username);
        this.profileViewModel.setState(profileState);
        profileViewModel.firePropertyChanged();

        // Switch to the profile view
        viewManagerModel.setState(profileViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }

    // fill in the other switch things
    public void switchToCreateStudyView(String username){
        viewManagerModel.setState(createStudyViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }

    @Override
    public void switchToEditExperimentView(String username) {
        final EditStudyState editStudyState = editStudyViewModel.getState();
        editStudyState.setUser(username);
        System.out.println(editStudyState);
        this.editStudyViewModel.setState(editStudyState);
        editStudyViewModel.firePropertyChanged();

        // Switch to the profile view
        viewManagerModel.setState(editStudyViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }

    @Override
    public void switchToEnterIDView(String username) {
        final EnterIDState enterIDState = enterIDViewModel.getState();
        enterIDState.setUsername(username);
        this.enterIDViewModel.setState(enterIDState);
        enterIDViewModel.firePropertyChanged();
        viewManagerModel.setState(enterIDViewModel.getViewName());
        viewManagerModel.firePropertyChanged();


    }


}
