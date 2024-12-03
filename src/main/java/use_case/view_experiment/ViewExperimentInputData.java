package use_case.view_experiment;

import entity.CommonStudy;
import entity.User;

public class ViewExperimentInputData {

    private String id;

    public ViewExperimentInputData(String id) {
        this.id = id;
    }

    public String getId() { return id; }
}
