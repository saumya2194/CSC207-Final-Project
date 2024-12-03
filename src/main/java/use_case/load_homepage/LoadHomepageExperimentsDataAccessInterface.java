package use_case.load_homepage;

import java.util.List;

import entity.CommonStudy;

/**
 * DAO for the editStudy useCase.
 */
public interface LoadHomepageExperimentsDataAccessInterface {

    /**
     * Gets research study based on id.
     * @param id string to find study.
     * @return CommonStudy.
     */
    CommonStudy getResearchStudy(String id);

    /**
     * Gets all research studies.
     * @return List of CommonStudies.
     */
    List<CommonStudy> getStudyObjects();

    /**
     * Gets research studies made by user.
     * @param username string to find their studies.
     * @return List of CommonStudies.
     */
    List<CommonStudy> retrieveUserStudies(String username);

}
