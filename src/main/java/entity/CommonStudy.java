package entity;

import java.util.UUID;

/**
 Class representation of the Common Study.
 Common Study is created by the User. Unique study ID is created along
 with the Study object upon its initialization.
 */

public class CommonStudy implements Study {
    private final String id;
    private final String user;
    private final String title;
    private final String details;


    // Changed the code so CommonStudy.user type will always be CommonUser object rather than String

    public CommonStudy(String user, String title, String details) {
        // UUID and hashcode will ensure that
        this.id = String.valueOf(UUID.randomUUID().hashCode());
        this.user = user;
        this.title = title;
        this.details = details;
    }

    // Overload the method if id of the study is already known.
    public CommonStudy(String user, String title, String details, String id) {
        this.id = id;
        this.user = user;
        this.title = title;
        this.details = details;
    }

    public String getId() {
        return this.id;
    }

    @Override
    public String getUser() {
        return this.user;
    }

    public String getTitle() {
        return this.title;
    }
    public String getDetails() {
        return this.details;
    }
}


