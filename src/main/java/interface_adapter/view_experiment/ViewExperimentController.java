package interface_adapter.view_experiment;

import entity.CommonStudy;
import use_case.view_experiment.ViewExperimentInputBoundary;
import use_case.view_experiment.ViewExperimentInputData;

public class ViewExperimentController {
    private final ViewExperimentInputBoundary view;

    public ViewExperimentController(ViewExperimentInputBoundary view) {
        this.view = view;
    }

    public void execute(CommonStudy study){
        ViewExperimentInputData inputData = new ViewExperimentInputData(study);
        view.execute(inputData);
    }
}
