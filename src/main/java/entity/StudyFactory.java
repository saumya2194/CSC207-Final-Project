package entity;

/**
 * Factory for creating studies.
 */
public interface StudyFactory {

    /**
     * Creates a new Study.
     * @param title title of the new study.
     * @param details the details of the new study.
     * @param user the name of the user creating the study.
     * @return the new study
     */
    CommonStudy create(String user, String title, String details);

    // Overload the create factory if study id is known so we can generate the original study back.
    CommonStudy create(String user, String title, String details, String id);

}
