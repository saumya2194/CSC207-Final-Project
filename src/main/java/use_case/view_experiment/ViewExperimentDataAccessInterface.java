package use_case.view_experiment;

import entity.ResearchStudy;

public interface ViewExperimentDataAccessInterface {
    ResearchStudy getResearchStudy(int id);
}
