package interface_adapter.homepage;// info about package, import


import use_case.homepage.LoadHomepageInputBoundry;
import use_case.homepage.LoadHomepageInputData;

public class LoadHomepageController {
    private final LoadHomepageInputBoundry loadHomepageUseCaseInteractor;

    public LoadHomepageController(LoadHomepageInputBoundry loadHomepageUseCaseInteractor) {
        this.loadHomepageUseCaseInteractor = loadHomepageUseCaseInteractor;
    }

    public void execute(String email, String password) {
        final LoadHomepageInputData loadHomepageInputData = new LoadHomepageInputData(username)
    }
}