package use_case.createstudy;

import entity.Study;

/**
 * DAO for create study use case
 */
public interface CreateStudyDataAccessInterface {

    /**
     * Saves the study.
     * @param study the study to save
     */
    void save(Study study);
}

}
