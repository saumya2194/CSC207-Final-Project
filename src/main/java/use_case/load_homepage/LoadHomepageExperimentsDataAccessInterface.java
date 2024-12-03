package use_case.load_homepage;

import entity.CommonStudy;

import java.util.List;

public interface LoadHomepageExperimentsDataAccessInterface {

    CommonStudy getResearchStudy(String id);

    List<CommonStudy> getStudyObjects();

    List<CommonStudy> retrieveUserStudies(String username);

}
