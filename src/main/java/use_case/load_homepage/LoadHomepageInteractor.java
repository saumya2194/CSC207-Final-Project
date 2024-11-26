package java.use_case.load_homepage;

public class LoadHomepageInteractor implements LoadHomepageInputBoundry{
    // TODO: ADD DAO
    private final LoadHomepageOutputBoundry loadHomepagePresenter;
    private final LoadHomepageExperimentsDataAccessInterface experimentsDataAccessObject;

    public LoadHomepageInteractor(LoadHomepageOutputBoundry loadHomepagePresenter,
                                  LoadHomepageExperimentsDataAccessInterface loadHomepageExperimentsDataAccessInterface) {
        //add dao
        this.loadHomepagePresenter = loadHomepagePresenter;
        this.experimentsDataAccessObject = loadHomepageExperimentsDataAccessInterface;
    }

    public void execute(LoadHomepageInputData loadHomepageInputData){
        // add some stuff
        // gather the total collection of experiments
        // maybe gather your experiments out of total collection
        // gathering these collections may or may not need for loops

        // create lists to store studies and my studies
        Object[] exps = experimentsDataAccessObject.getResearchStudies();
        Object[] myExps = new Object[];

        // load my studies into my_exps
        for (ResearchStudy study : experimentsDataAccessObject.getResearchStudies()) {
            u = study.getUser();
            if (u == loadHomepageInputData.getUser()){
                myExps += i;
            }
        }

        final LoadHomepageOutputData loadHomepageOutputData(exps, myExps, loadHomepageInputData.getUser(), false)
        loadHomepagePresenter.prepareSuccessView(loadHomepageOutputData);
    }



    public void switchToViewProfileView(){loadHomepagePresenter.switchToViewProfileView();};

    public void switchToCreateExperimentView(){loadHomepagePresenter.switchToCreateExperimentView();}

    public void switchToLogoutView(){loadHomepagePresenter.switchToLogoutView();}


}
