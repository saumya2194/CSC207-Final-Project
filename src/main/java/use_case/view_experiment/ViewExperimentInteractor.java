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
        CommonStudy commonStudy = null;
        try {
            commonStudy = viewExperimentDataAccessInterface.getResearchStudy(viewExperimentInputData
                    .getResearchStudy().getId());
        } catch (data_access.DataAccessException e) {
            throw new RuntimeException(e);
        }
        if (commonStudy == null) {
            throw new IllegalArgumentException("Research Experiment not found.");
        }
        ViewExperimentOutputData viewExperimentOutputData = new ViewExperimentOutputData(commonStudy.getTitle(),
                commonStudy.getDetails(), commonStudy.getResearcherName());
        viewExperimentOutputBoundary.present(viewExperimentOutputData);
    }

}
