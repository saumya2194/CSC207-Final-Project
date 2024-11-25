package interface_adapter.create_experiment;

/**
 * The state for the Login View Model.
 */
public class CreateExperimentState {
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
