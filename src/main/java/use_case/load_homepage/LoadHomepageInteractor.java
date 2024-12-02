package use_case.load_homepage;

import entity.CommonStudy;
import use_case.load_homepage.LoadHomepageInputData;
import use_case.load_homepage.LoadHomepageOutputBoundry;
import use_case.load_homepage.LoadHomepageExperimentsDataAccessInterface;
import use_case.load_homepage.LoadHomepageOutputData;
import java.util.ArrayList;
import entity.CommonUser;
import java.util.List;

public class LoadHomepageInteractor implements LoadHomepageInputBoundry{
    // TODO: ADD DAO
    private final LoadHomepageOutputBoundry loadHomepagePresenter;
    private final LoadHomepageExperimentsDataAccessInterface experimentsDataAccessObject;

    public LoadHomepageInteractor(LoadHomepageOutputBoundry loadHomepageOutputBoundry,
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



    public void switchToProfileView(){loadHomepagePresenter.switchToProfileView();};

    public void switchToCreateStudyView(){loadHomepagePresenter.switchToCreateStudyView();}

    public void switchToEditExperimentView(String data) {

        loadHomepagePresenter.switchToEditExperimentView(data);
    }

    public void switchToViewExperimentView(String data) {
        loadHomepagePresenter.switchToViewExperimentView(data);
    }


}
