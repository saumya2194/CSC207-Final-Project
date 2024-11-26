package use_case.view_experiment;

import entity.CommonResearchStudy;

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
        CommonResearchStudy commonResearchStudy = viewExperimentDataAccessInterface.getResearchStudy(viewExperimentInputData
                .getResearchStudy().getId());
        if (commonResearchStudy == null) {
            throw new IllegalArgumentException("Research Experiment not found.");
        }
        ViewExperimentOutputData viewExperimentOutputData = new ViewExperimentOutputData(commonResearchStudy.getTitle(),
                commonResearchStudy.getDetails(), commonResearchStudy.getResearcherName());
        viewExperimentOutputBoundary.present(viewExperimentOutputData);
    }

}
