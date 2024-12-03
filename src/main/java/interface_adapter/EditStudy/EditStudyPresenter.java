package interface_adapter.EditStudy;

import interface_adapter.ViewManagerModel;
import interface_adapter.createstudy.CreateStudyState;
import interface_adapter.load_homepage.HomepageState;
import interface_adapter.load_homepage.HomepageViewModel;
import use_case.editStudy.EditStudyOutputBoundary;
import use_case.editStudy.EditStudyOutputData;
import use_case.login.LoginOutputData;

/**
 * The Presenter for the editStudy View Model.
 */

public class EditStudyPresenter implements EditStudyOutputBoundary {
    private final HomepageViewModel homepageViewModel;
    private final ViewManagerModel viewManagerModel;
    private final EditStudyViewModel editStudyViewModel;

    public EditStudyPresenter(HomepageViewModel homepageViewModel, ViewManagerModel viewManagerModel,
    EditStudyViewModel editStudyviewModel) {
        this.homepageViewModel = homepageViewModel;
        this.viewManagerModel = viewManagerModel;
        this.editStudyViewModel = editStudyviewModel;

    }
    @Override
    public void prepareSuccessView(EditStudyOutputData response) {
        // switch to HomePageView
        final HomepageState homepageState = homepageViewModel.getState();
        this.homepageViewModel.setState(homepageState);
        this.homepageViewModel.firePropertyChanged();
        this.viewManagerModel.setState(homepageViewModel.getViewName());
        this.viewManagerModel.firePropertyChanged();

    }

    @Override
    public void prepareFailView(String errorMessage) {

        final EditStudyState editStudyState = editStudyViewModel.getState();
        editStudyState.setDetailsError(errorMessage);
        editStudyViewModel.firePropertyChanged();

    }
}
