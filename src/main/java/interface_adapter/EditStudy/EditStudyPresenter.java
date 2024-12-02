package interface_adapter.EditStudy;

import interface_adapter.ViewManagerModel;
import interface_adapter.load_homepage.HomepageState;
import interface_adapter.load_homepage.HomepageViewModel;
import use_case.editStudy.EditStudyOutputBoundary;
import use_case.editStudy.EditStudyOutputData;
import use_case.login.LoginOutputData;

/**
 * The Presenter for the editStudy usecase.
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
        final HomepageState homepageState = HomepageViewModel.getState();
        this.viewManagerModel.setState();
        this.viewManagerModel.firePropertyChanged();

    }

    @Override
    public void prepareFailView(String errorMessage) {


    }
}
