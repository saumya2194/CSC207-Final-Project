package use_case.view_experiment;

import data_access.DataAccessException;
import entity.CommonStudy;

public interface ViewExperimentDataAccessInterface {
    CommonStudy getResearchStudy(String id) throws DataAccessException;
}
