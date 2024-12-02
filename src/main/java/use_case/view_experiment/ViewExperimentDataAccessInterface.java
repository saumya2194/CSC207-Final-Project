package use_case.view_experiment;

import data_access.DataAccessException;
import entity.CommonStudy;
import entity.Study;
import org.json.JSONArray;

public interface ViewExperimentDataAccessInterface {
    JSONArray getStudies ();


    public Study getResearchStudy();
}
