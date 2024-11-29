package interface_adapter.view_experiment;

public class ViewExperimentState {
    private String title;
    private String details;
    private String viewExperimentError;

    public String getTitle() {return title;}
    public String getDetails() {return details;}
    public void setTitle(String title) {this.title = title;}
    public void setDetails(String details) {this.details = details;}
    public String getViewExperimentError() {return viewExperimentError;}
    public void setViewExperimentError(String errormessage) {this.viewExperimentError = errormessage;}
}
