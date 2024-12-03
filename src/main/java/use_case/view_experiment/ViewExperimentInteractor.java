package use_case.view_experiment;

import entity.CommonStudy;


public class ViewExperimentInteractor implements ViewExperimentInputBoundary{

    private final ViewExperimentDataAccessInterface viewExperimentDataAccessInterface;
    private final ViewExperimentOutputBoundary viewExperimentOutputBoundary;

    public ViewExperimentInteractor(ViewExperimentDataAccessInterface viewExperimentDataAccessInterface,
                                    ViewExperimentOutputBoundary viewExperimentOutputBoundary) {
        this.viewExperimentDataAccessInterface = viewExperimentDataAccessInterface;
        this.viewExperimentOutputBoundary = viewExperimentOutputBoundary;
    }

    @Override
    public void execute(ViewExperimentInputData viewExperimentInputData) {
        CommonStudy commonStudy = viewExperimentDataAccessInterface.getResearchStudy(viewExperimentInputData.getId());
        ViewExperimentOutputData viewExperimentOutputData = new ViewExperimentOutputData(commonStudy.getId(), commonStudy.getTitle(),
                commonStudy.getDetails(), commonStudy.getUser());
        if (viewExperimentOutputData != null) {
            viewExperimentOutputBoundary.prepareSuccessView(viewExperimentOutputData);
        }
        else {
            viewExperimentOutputBoundary.prepareFailView("Experiment not found");
        }

    }
}
