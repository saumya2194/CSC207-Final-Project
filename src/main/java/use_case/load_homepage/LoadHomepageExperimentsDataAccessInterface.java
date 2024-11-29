package java.use_case.load_homepage;

public interface LoadHomepageExperimentsDataAccessInterface {

    CommonStudy getResearchStudy(int id);

    List<CommonStudy> getStudyObjects();

}
