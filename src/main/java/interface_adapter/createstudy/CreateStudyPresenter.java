package interface_adapter.createstudy;

import interface_adapter.ViewManagerModel;
import interface_adapter.load_homepage.HomepageState;
import interface_adapter.load_homepage.HomepageViewModel;
import use_case.createstudy.CreateStudyOutputBoundary;
import use_case.createstudy.CreateStudyOutputData;

/**
 * The Presenter for the Create Study Use Case.
 */
public class CreateStudyPresenter implements CreateStudyOutputBoundary {

    private final CreateStudyViewModel createStudyViewModel;

    private final HomepageViewModel homepageViewModel;
    private final ViewManagerModel viewManagerModel;

    public CreateStudyPresenter(ViewManagerModel viewManagerModel,
                                HomepageViewModel homepageViewModel,
                                CreateStudyViewModel createStudyViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.createStudyViewModel = createStudyViewModel;
        this.homepageViewModel = homepageViewModel;
    }

    @Override
    public void prepareSuccessView(CreateStudyOutputData response) {
        // On success, switch to the homepage view.
        final HomepageState homepageState = homepageViewModel.getState();
        this.homepageViewModel.setState(homepageState);
        this.homepageViewModel.firePropertyChanged();
        this.viewManagerModel.setState(homepageViewModel.getViewName());
        this.viewManagerModel.firePropertyChanged();

    }

    @Override
    public void prepareFailView(String error) {
        final CreateStudyState createStudyState = createStudyViewModel.getState();
        createStudyState.setDetailsError(error);
        createStudyViewModel.firePropertyChanged();
    }

    @Override
    public void switchToHomepageView() {
        viewManagerModel.setState(HomepageViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }
}
