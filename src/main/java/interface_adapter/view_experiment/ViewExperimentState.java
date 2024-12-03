package interface_adapter.view_experiment;

public class ViewExperimentState {
    private String id;
    private String title;
    private String details;
    private String username;
    private String viewExperimentError;

    public String getId() {return id;}
    public String getTitle() {return title;}
    public String getDetails() {return details;}
    public void setId(String id) {this.id = id;}
    public void setTitle(String title) {this.title = title;}
    public void setDetails(String details) {this.details = details;}
    public String getViewExperimentError() {return viewExperimentError;}
    public void setViewExperimentError(String errormessage) {this.viewExperimentError = errormessage;}
    public String getUsername() {return username;}
    public void setUsername(String username) {this.username = username;}
}
