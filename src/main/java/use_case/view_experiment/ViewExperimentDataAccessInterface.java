package use_case.view_experiment;

import entity.CommonStudy;
import org.json.JSONArray;

public interface ViewExperimentDataAccessInterface {
    JSONArray getStudies ();
    CommonStudy getResearchStudy (String ID);
}
