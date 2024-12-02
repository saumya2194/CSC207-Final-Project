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

    public EditStudyPresenter(HomepageViewModel homepageViewModel, ViewManagerModel viewManagerModel) {
        this.homepageViewModel = homepageViewModel;
        this.viewManagerModel = viewManagerModel;

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

        // TODO: fix non static method error
        final CreateStudyState createStudyState = EditStudyViewModel.getState();
        createStudyState.setDetailsError(errorMessage);
        EditStudyViewModel.firePropertyChanged();

    }
}
