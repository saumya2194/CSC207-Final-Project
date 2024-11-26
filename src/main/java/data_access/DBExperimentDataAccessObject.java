package data_access;

import entity.CommonResearchStudy;
import use_case.view_experiment.ViewExperimentDataAccessInterface;

public class DBExperimentDataAccessObject implements ViewExperimentDataAccessInterface {
    @Override
    public CommonResearchStudy getResearchStudy(int id) {
        return null;
    }


    Boolean saveStudy(CommonResearchStudy study) {
        return false;
    }
}
