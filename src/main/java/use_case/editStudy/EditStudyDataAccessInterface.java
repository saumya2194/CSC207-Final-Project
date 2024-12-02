package use_case.editStudy;

import entity.CommonStudy;

/**
 * DAO for the editStudy useCase.
 */

public interface EditStudyDataAccessInterface {

    /**
     * Edits existing study based on a newStudy's title and description.
     * @param newStudy
     * @return
     */

    boolean editStudy(CommonStudy newStudy);

}
