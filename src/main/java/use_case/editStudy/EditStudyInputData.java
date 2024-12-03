package use_case.editStudy;

import entity.CommonStudy;

public class EditStudyInputData {
    private final String title;
    private final String details;
    private final String user;
    private final String ID;

    public EditStudyInputData(String title, String details, String user, String ID) {

        this.title = title;
        this.details = details;
        this.user = user;
        this.ID = ID;
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
        return ID;
    }
}
