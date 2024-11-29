package use_case.createstudy;

/**
 * Output Data for the Create Study Use Case.
 */
public class CreateStudyOutputData {

    private final String title;
    private final String details;

    private final boolean useCaseFailed;

    public CreateStudyOutputData(String title, String details, boolean useCaseFailed) {
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
