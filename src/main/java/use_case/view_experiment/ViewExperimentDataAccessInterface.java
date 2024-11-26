package use_case.view_experiment;

import entity.CommonStudy;

public interface ViewExperimentDataAccessInterface {
    CommonStudy getResearchStudy(String id);
}
