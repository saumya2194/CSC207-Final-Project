package interface_adapter.EditStudy;

/**
 * The state for the EditStudy useCase.
 */

public class EditStudyState {
    private String title;
    private String details;
    private String user;
    private String ID;
    private String detailsError;
    private String titleError;

    public String getTitle() {
        return title;
    }

    public String getDetails() {
        return details;
    }

    public String getDetailsError() {
        return detailsError;
    }

    public String getTitleError() { return titleError; }

    public String getID() { return ID; }

    public String getUser() {
        return this.user;
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

    public void setUser(String user) {
        this.user = user;
    }

}
