package use_case.view_experiment;

import entity.ResearchStudy;

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
        ResearchStudy researchStudy = viewExperimentDataAccessInterface.getResearchStudy(viewExperimentInputData.getResearchStudy().getId());
        if (researchStudy == null) {
            throw new IllegalArgumentException("Research Experiment not found.");
        }
        ViewExperimentOutputData viewExperimentOutputData = new ViewExperimentOutputData(researchStudy.getTitle(),
                researchStudy.getDetails(), researchStudy.getResearcherName());
        viewExperimentOutputBoundary.present(viewExperimentOutputData);
    }

}
