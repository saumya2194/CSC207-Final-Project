package interface_adapter.view_experiment;

import use_case.view_experiment.ViewExperimentInputBoundary;
import use_case.view_experiment.ViewExperimentInputData;

public class ViewExperimentController {
    private final ViewExperimentInputBoundary view;

    public ViewExperimentController(ViewExperimentInputBoundary view) {
        this.view = view;
    }

    public void execute(String id){
        ViewExperimentInputData inputData = new ViewExperimentInputData(id);
        view.execute(inputData);
    }

    public void switchToHomepageView() {

    }
}
