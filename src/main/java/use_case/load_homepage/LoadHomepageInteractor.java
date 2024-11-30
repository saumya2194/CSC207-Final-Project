package use_case.load_homepage;

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
        //add dao
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
        Object[] exps = experimentsDataAccessObject.getStudyObjects().toArray();

        // load my studies into my_exps
        Object[] myExps = experimentsDataAccessObject.retrieveUserStudies(loadHomepageInputData.getUser()).toArray();

        final LoadHomepageOutputData loadHomepageOutputData = new LoadHomepageOutputData(exps, myExps, loadHomepageInputData.getUser(), false);
        loadHomepagePresenter.prepareSuccessView(loadHomepageOutputData);
    }



    public void switchToProfileView(){loadHomepagePresenter.switchToProfileView();};

    public void switchToCreateStudyView(){loadHomepagePresenter.switchToCreateStudyView();}



}
