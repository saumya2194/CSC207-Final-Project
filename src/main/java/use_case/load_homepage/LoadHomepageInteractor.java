package use_case.load_homepage;

import java.util.List;

import entity.CommonStudy;


/**
 * The LoadHomepage Interactor.
 */
public class LoadHomepageInteractor implements LoadHomepageInputBoundary {
    private final LoadHomepageOutputBoundary loadHomepagePresenter;
    private final LoadHomepageExperimentsDataAccessInterface experimentsDataAccessObject;

    public LoadHomepageInteractor(LoadHomepageOutputBoundary loadHomepageOutputBoundry,
                                  LoadHomepageExperimentsDataAccessInterface loadHomepageExperimentsDataAccessInterface) {
        // add dao
        this.loadHomepagePresenter = loadHomepageOutputBoundry;
        this.experimentsDataAccessObject = loadHomepageExperimentsDataAccessInterface;
    }

    @Override
    public void execute(LoadHomepageInputData loadHomepageInputData){
        // add some stuff
        // gather the total collection of experiments
        // maybe gather your experiments out of total collection
        // gathering these collections may or may not need for loops

        // create lists to store studies and my studies
        final List<CommonStudy> exps = experimentsDataAccessObject.getStudyObjects();
        final CommonStudy[] experiments = exps.toArray(new CommonStudy[exps.size()]);

        // load my studies into my_exps
        final List<CommonStudy> myExps = experimentsDataAccessObject.retrieveUserStudies(loadHomepageInputData.getUser());
        final CommonStudy[] myExperiments = myExps.toArray(new CommonStudy[myExps.size()]);

        final LoadHomepageOutputData loadHomepageOutputData = new LoadHomepageOutputData(experiments, myExperiments, loadHomepageInputData.getUser(), false);
        loadHomepagePresenter.prepareSuccessView(loadHomepageOutputData);
    }



    /**
     * The switch to profile view.
     * @param username string of profile.
     */
    public void switchToProfileView(String username) {
        loadHomepagePresenter.switchToProfileView(username);
    }

    /**
     * The switch to create study view.
     * @param username string of profile.
     */
    public void switchToCreateStudyView(String username) {
        loadHomepagePresenter.switchToCreateStudyView(username);
    }

    /**
     * The switch to edit experiment view.
     * @param username string of profile.
     */
    public void switchToEditExperimentView(String username) {

        loadHomepagePresenter.switchToEditExperimentView(username);
    }
    /**
     * The switch to enter id view.
     * @param username string of profile.
     */
    public void switchToEnterIDView(String username) {
        loadHomepagePresenter.switchToEnterIDView(username);
    }

}
