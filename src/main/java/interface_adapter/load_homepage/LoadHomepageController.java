package interface_adapter.load_homepage;// info about package, import
import entity.CommonUser;
import use_case.load_homepage.LoadHomepageInputBoundry;
import use_case.load_homepage.LoadHomepageInputData;

public class LoadHomepageController {
    private final LoadHomepageInputBoundry loadHomepageUseCaseInteractor;

    public LoadHomepageController(LoadHomepageInputBoundry loadHomepageUseCaseInteractor) {
        this.loadHomepageUseCaseInteractor = loadHomepageUseCaseInteractor;
    }

    public void execute(CommonUser user) {
        final LoadHomepageInputData loadHomepageInputData = new LoadHomepageInputData(user);
        loadHomepageUseCaseInteractor.execute(loadHomepageInputData);
    }

    public void switchToViewProfileView(){loadHomepageUseCaseInteractor.switchToViewProfileView();}

    public void switchToCreateExperimentView(){loadHomepageUseCaseInteractor.switchToCreateExperimentView();}

}