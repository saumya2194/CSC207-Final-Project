package data_access;

import entity.CommonStudy;
import entity.Study;
import entity.User;
import org.json.JSONArray;
import use_case.load_homepage.LoadHomepageExperimentsDataAccessInterface;
import use_case.login.LoginUserDataAccessInterface;
import use_case.logout.LogoutUserDataAccessInterface;
import use_case.createstudy.CreateStudyDataAccessInterface;
import use_case.view_experiment.ViewExperimentDataAccessInterface;
import use_case.view_profile.ViewProfileUserDataAccessInterface;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryExperimentDataAccessObject implements LoadHomepageExperimentsDataAccessInterface,
        ViewExperimentDataAccessInterface,
        CreateStudyDataAccessInterface {

    private Map<String, CommonStudy> studies = new HashMap<>();

    @Override
    public CommonStudy getResearchStudy(String id) {
        return studies.get(id);
    }

    @Override
    public List<CommonStudy> getStudyObjects() {
        List<CommonStudy> result = new ArrayList<CommonStudy>(studies.values());
        return result;
    }

    @Override
    public List<CommonStudy> retrieveUserStudies(String username) {
        List<CommonStudy> totalStudies = new ArrayList<>(studies.values());
        List<CommonStudy> result = new ArrayList<CommonStudy>();
        for (CommonStudy study : totalStudies) {
            if (study.getUser().equals(username)) {
                result.add(study);
            }
        }
        return result;
    }

    @Override
    public JSONArray getStudies() {
        return null;
    }

    @Override
    public void save(Study study) {
        studies.put(study.getTitle(), (CommonStudy) study);
    }
}
