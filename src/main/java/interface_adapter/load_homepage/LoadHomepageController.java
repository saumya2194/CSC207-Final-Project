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

    public void switchToCreateStudyView(){ loadHomepageUseCaseInteractor.switchToCreateStudyView();}

    public void switchToEditExperimentView(String data) {
        loadHomepageUseCaseInteractor.switchToEditExperimentView(data);
    }

    public void switchToViewExperimentView(String data) {
        loadHomepageUseCaseInteractor.switchToViewExperimentView(data);
    }
}