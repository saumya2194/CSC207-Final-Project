package use_case.view_experiment;

import entity.CommonResearchStudy;

public interface ViewExperimentDataAccessInterface {
    CommonResearchStudy getResearchStudy(int id);
}
