package java;// info about package, import
import main.java.LoadHomepageInputBoundry;

public class LoadHomepageController {
    private final LoadHomepageInputBoundry loadHomepageUseCaseInteractor;

    public LoadHomepageController(main.java.LoadHomepageInputBoundry loadHomepageUseCaseInteractor) {
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