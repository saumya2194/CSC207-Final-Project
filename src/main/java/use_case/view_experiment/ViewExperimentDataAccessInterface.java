package use_case.view_experiment;

import data_access.DataAccessException;
import entity.CommonStudy;
import org.json.JSONArray;

public interface ViewExperimentDataAccessInterface {
    JSONArray getStudies ();
}
