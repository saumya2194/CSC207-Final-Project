package data_access;

import entity.CommonStudy;
import use_case.view_experiment.ViewExperimentDataAccessInterface;

public class DBExperimentDataAccessObject implements ViewExperimentDataAccessInterface {
    @Override
    public CommonStudy getResearchStudy(int id) {
        return null;
    }


    Boolean saveStudy(CommonStudy study) {
        return false;
    }
}
