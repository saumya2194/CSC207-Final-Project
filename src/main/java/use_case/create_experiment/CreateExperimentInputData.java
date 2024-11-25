package use_case.create_experiment;

import java.util.UUID;

import entity.User;

/**
 * The Input Data for the Create Experiment  Use Case.
 */
public class CreateExperimentInputData {

    private final int id;
    private User user;
    private String title;
    private String details;

    public CreateExperimentInputData(String title, String details, User user) {
        this.title = title;
        this.details = details;
        this.user = user;
        this.id = UUID.randomUUID().hashCode();

    }

    String getTitle() {
        return title;
    }

    String getDetails() {
        return details;
    }
}
