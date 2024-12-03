package use_case.editStudy;

/**
 * Output data for EditStudy usecase.
 */
public class EditStudyOutputData {
    private final String title;
    private final String details;
    private final boolean useCaseFailed;


    public EditStudyOutputData(String title, String details, boolean useCaseFailed) {
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
