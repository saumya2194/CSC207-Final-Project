package data_access;

import entity.ResearchStudy;
import use_case.view_experiment.ViewExperimentDataAccessInterface;

public class DBExperimentDataAccessObject implements ViewExperimentDataAccessInterface {
    @Override
    public ResearchStudy getResearchStudy(int id) {
        return null;
    }


    Boolean saveStudy(ResearchStudy study) {
        return false;
    }
}
