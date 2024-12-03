package use_case.view_experiment;

public class ViewExperimentOutputData {
    private String id;
    private String title;
    private String description;
    private String author;

    public ViewExperimentOutputData(String id, String title, String description, String author) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.author = author;
    }

    public String getId() {return id;}
    public String getTitle() { return title; }
    public String getDetails() { return description; }
    public String getUser() { return author; }
}
