package use_case.create_experiment;

/**
 * The Input Data for the Create Experiment  Use Case.
 */
public class CreateExperimentInputData {

    private final String title;
    private final String details;

    public CreateExperimentInputData(String title, String details) {
        this.title = title;
        this.details = details;
    }

    String getTitle() {
        return title;
    }

    String getDetails() {
        return details;
    }
}
