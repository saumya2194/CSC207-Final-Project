package entity;

import java.util.UUID;
/**
 Class representation of the ResearchStudy.
 ResearchStudy is created by Researcher only and maps onto the Participants that are enrolled. Unique
 study ID is created along with the ResearchStudy object upon its initialization.
 */
public class ResearchStudy {
    private final String id;
    private String user;
    private String title;
    private String details;

    public ResearchStudy(String user, String title, String details) {
        this.id = String.valueOf(UUID.randomUUID().hashCode());
        this.user = user;
        this.title = title;
        this.details = details;
    }

    public String getId() {return this.id;}
    public String getResearcherName() {return user;}
    public String getTitle() {
        return this.title;
    }
    public String getDetails() {
        return this.details;
    }
}


