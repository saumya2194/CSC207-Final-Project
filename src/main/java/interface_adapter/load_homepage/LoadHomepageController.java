package interface_adapter.load_homepage; // info about package, import
import use_case.load_homepage.LoadHomepageInputBoundary;
import use_case.load_homepage.LoadHomepageInputData;

public class LoadHomepageController {
    private final LoadHomepageInputBoundary loadHomepageUseCaseInteractor;

    public LoadHomepageController(LoadHomepageInputBoundary loadHomepageUseCaseInteractor) {
        this.loadHomepageUseCaseInteractor = loadHomepageUseCaseInteractor;
    }

    public void execute(String user) {
        final LoadHomepageInputData loadHomepageInputData = new LoadHomepageInputData(user);
        loadHomepageUseCaseInteractor.execute(loadHomepageInputData);
    }

    public void switchToViewProfileView(String username){ loadHomepageUseCaseInteractor.switchToProfileView(username);}

    public void switchToCreateStudyView(String username){ loadHomepageUseCaseInteractor.switchToCreateStudyView(username);}

    public void switchToEditExperimentView(String username) {
        loadHomepageUseCaseInteractor.switchToEditExperimentView(username);
    }

    public void switchToEnterIDView(String username) {
        loadHomepageUseCaseInteractor.switchToEnterIDView(username);
    }
}