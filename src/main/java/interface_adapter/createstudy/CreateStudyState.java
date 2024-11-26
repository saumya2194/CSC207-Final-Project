package interface_adapter.createstudy;

/**
 * The state for the Create Study View Model.
 */
public class CreateStudyState {
    private String title = "";
    private String details = "";

    public String getTitle() {
        return title;
    }

    public String getDetails() {
        return details;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
