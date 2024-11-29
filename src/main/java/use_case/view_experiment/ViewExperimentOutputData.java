package use_case.view_experiment;

public class ViewExperimentOutputData {
    private String title;
    private String description;
    private String author;

    public ViewExperimentOutputData(String title, String description, String author) {
        this.title = title;
        this.description = description;
        this.author = author;
    }

    public String getTitle() { return title; }
    public String getDescription() { return description; }
    public String getAuthor() { return author; }
}
