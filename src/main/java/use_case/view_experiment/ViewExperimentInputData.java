package use_case.view_experiment;

import entity.ResearchStudy;
import entity.User;

public class ViewExperimentInputData {

    private ResearchStudy researchStudy;
    private User user;

    public ViewExperimentInputData(ResearchStudy researchStudy, User user) {
        this.researchStudy = researchStudy;
        this.user= user;
    }

    public ResearchStudy getResearchStudy() {return researchStudy;}
    public User getUser() { return user; }
}
