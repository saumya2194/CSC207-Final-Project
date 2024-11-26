package use_case.view_experiment;

import entity.CommonResearchStudy;
import entity.User;

public class ViewExperimentInputData {

    private CommonResearchStudy commonResearchStudy;
    private User user;

    public ViewExperimentInputData(CommonResearchStudy commonResearchStudy, User user) {
        this.commonResearchStudy = commonResearchStudy;
        this.user= user;
    }

    public CommonResearchStudy getResearchStudy() {return commonResearchStudy;}
    public User getUser() { return user; }
}
