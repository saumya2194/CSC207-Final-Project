package interface_adapter.createstudy;

/**
 * The state for the Create Study View Model.
 */
public class CreateStudyState {
    private String title = "";
    private String details = "";
    private String detailsError = "";

    public String getTitle() {
        return title;
    }

    public String getDetails() {
        return details;
    }

    public String getDetailsError() {
        return detailsError;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public void setDetailsError(String detailsError) {
        this.detailsError = detailsError;
    }

    public String toString() {
        return "CreateStudyState{"
                + "title='" + title + '\''
                + ", details='" + details + '\''
                + '}';
    }
}


@Override
