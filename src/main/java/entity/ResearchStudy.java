package entity;

/**
 Class representation of the ResearchStudy.
 ResearchStudy is created by Researcher only and maps onto the Participants that are enrolled. Unique
 study ID is created along with the ResearchStudy object upon its initialization.
 */
public class ResearchStudy {
    String title;
    String details;
    String studyContact;
    public ResearchStudy(String title, String details) {
        this.title = title;
        this.details = details;
    }
    public void setStudyContact() {
        this.studyContact = ""; // Initialize as empty and we will grab the Researcher's contact later.

    }
    public String getTitle() {
        return this.title;
    }
    public String getDetails() {
        return this.details;
    }
}


