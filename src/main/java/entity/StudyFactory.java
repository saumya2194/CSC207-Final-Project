package entity;

/**
 * Factory for creating studies.
 */
public interface StudyFactory {

    /**
     * Creates a new Study.
     * @param title title of the new study.
     * @param details the details of the new study.
     * @param user the user creating the study.
     * @return the new study
     */
    Study create(String title, String details, User user);

}
