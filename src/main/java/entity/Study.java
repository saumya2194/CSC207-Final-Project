package entity;

/**
 * The respresentation of a study in our program.
 */
public interface Study {
    /**
     * Returns the title of the study.
     * @return the title of the study.
     */
    String getTitle();

    /**
     * Returns the details of the study.
     * @return the details of the study.
     */
    String getDetails();

    /**
     * Returns the user that created the study.
     * @return the user that created the study.
     */
    User getUser();

    //Todo: stirng user or user user

}
