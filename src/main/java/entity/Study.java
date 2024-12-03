package entity;

/**
 * The representation of a study in our program.
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
     * Returns the username that created the study.
     * @return the username that created the study.
     */
    String getUser();

    /**
     * Returns the id of the study.
     * @return the id of the study.
     */
    String getId();


}
