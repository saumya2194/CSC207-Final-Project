package use_case.create_experiment;

/**
 * Output Data for the Create Experiment Use Case.
 */
public class CreateExperimentOutputData {

    private final String title;
    private final String details;

    private final boolean useCaseFailed;

    public CreateExperimentOutputData(String title, String details, boolean useCaseFailed) {
        this.title = title;
        this.details = details;
        this.useCaseFailed = useCaseFailed;
    }

    public String getTitle() {
        return title;
    }

    public String getDetails() {
        return details; }

}
