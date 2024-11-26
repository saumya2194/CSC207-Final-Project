package java;

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

    void switchToViewProfileView();

    void switchToCreateExperimentView();

    void switchToLogoutView();


}
