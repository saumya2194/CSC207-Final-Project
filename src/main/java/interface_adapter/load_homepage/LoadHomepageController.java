package java.interface_adapter.load_homepage;// info about package, import
import java.use_case.load_homepage.LoadHomepageInputBoundry;

public class LoadHomepageController {
    private final LoadHomepageInputBoundry loadHomepageUseCaseInteractor;

    public LoadHomepageController(LoadHomepageInputBoundry loadHomepageUseCaseInteractor) {
        this.loadHomepageUseCaseInteractor = loadHomepageUseCaseInteractor;
    }

    public void execute(User user) {
        final LoadHomepageInputData loadHomepageInputData = new LoadHomepageInputData(user);
        loadHomepageUseCaseInteractor.execute(loadHomepageInputData);
    }

    public void switchToViewProfileView(){loadHomepageUseCaseInteractor.switchToViewProfileView();}

    public void switchToCreateExperimentView(){loadHomepageUseCaseInteractor.switchToCreateExperimentView();}

    public void switchToLogoutView() {loadHomepageUseCaseInteractor.switchToLogoutView();}
}