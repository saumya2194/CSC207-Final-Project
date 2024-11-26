package use_case.view_experiment;

import entity.CommonStudy;
import entity.User;

public class ViewExperimentInputData {

    private CommonStudy commonStudy;
    private User user;

    public ViewExperimentInputData(CommonStudy commonStudy, User user) {
        this.commonStudy = commonStudy;
        this.user= user;
    }

    public CommonStudy getResearchStudy() {return commonStudy;}
    public User getUser() { return user; }
}
