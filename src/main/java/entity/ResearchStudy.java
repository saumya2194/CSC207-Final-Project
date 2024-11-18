package entity;

import java.util.UUID;
/**
 Class representation of the ResearchStudy.
 ResearchStudy is created by Researcher only and maps onto the Participants that are enrolled. Unique
 study ID is created along with the ResearchStudy object upon its initialization.
 */
public class ResearchStudy {
    private final int id;
    private CommonUser user;
    private String title;
    private String details;

    public ResearchStudy(CommonUser user, String title, String details) {
        this.id = UUID.randomUUID().hashCode();
        this.user = user;
        this.title = title;
        this.details = details;
    }

    public int getId() {return this.id;}
    public String getResearcherName() {return user.getName();}
    public String getTitle() {
        return this.title;
    }
    public String getDetails() {
        return this.details;
    }
}


