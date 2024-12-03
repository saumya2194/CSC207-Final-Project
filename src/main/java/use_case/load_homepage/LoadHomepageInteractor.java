package use_case.load_homepage;

import entity.CommonStudy;

import java.util.List;

public class LoadHomepageInteractor implements LoadHomepageInputBoundary {
    // TODO: ADD DAO
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
        List<CommonStudy> exps = experimentsDataAccessObject.getStudyObjects();
        CommonStudy[] experiments = exps.toArray(new CommonStudy[exps.size()]);

        // load my studies into my_exps
        List<CommonStudy> myExps = experimentsDataAccessObject.retrieveUserStudies(loadHomepageInputData.getUser());
        CommonStudy[] myExperiments = myExps.toArray(new CommonStudy[myExps.size()]);

        final LoadHomepageOutputData loadHomepageOutputData = new LoadHomepageOutputData(experiments, myExperiments, loadHomepageInputData.getUser(), false);
        loadHomepagePresenter.prepareSuccessView(loadHomepageOutputData);
    }



    public void switchToProfileView(String username) {
        loadHomepagePresenter.switchToProfileView(username);
    };

    public void switchToCreateStudyView(String username){loadHomepagePresenter.switchToCreateStudyView(username);}

    public void switchToEditExperimentView(String username) {

        loadHomepagePresenter.switchToEditExperimentView(username);
    }

    public void switchToEnterIDView(String username) {
        loadHomepagePresenter.switchToEnterIDView(username);
    }


}
