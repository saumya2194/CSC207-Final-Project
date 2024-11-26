package entity;

import java.util.UUID;
/**
 Class representation of the Common Study.
 Common Study is created by Researcher only and maps onto the Participants that are enrolled. Unique
 study ID is created along with the Study object upon its initialization.
 */

public class CommonStudy {
    private final int id;
    private User user;
    private String title;
    private String details;
    //TODO: figure whther user is string/user
    public CommonStudy(String user, String title, String details) {
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


