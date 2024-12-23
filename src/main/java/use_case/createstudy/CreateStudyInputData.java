package use_case.createstudy;

import entity.User;
import java.util.UUID;

/**
 * The Input Data for the Create Experiment  Use Case.
 */
public class CreateStudyInputData {

    private final String Id;
    private String user;
    private String title;
    private String details;

    public CreateStudyInputData(String title, String details, String user) {
        this.title = title;
        this.details = details;
        this.user = user;
        this.Id = String.valueOf(UUID.randomUUID().hashCode());

    }

    String getTitle() {
        return title;
    }

    String getDetails() {
        return details;
    }

    String getUser() {
        return user;
    }

    String getId() {
        return Id;
    }
}
