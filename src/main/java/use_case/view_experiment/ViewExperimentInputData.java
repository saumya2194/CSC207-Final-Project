package use_case.view_experiment;

import entity.CommonStudy;
import entity.User;

public class ViewExperimentInputData {

    private CommonStudy commonStudy;

    public ViewExperimentInputData(CommonStudy commonStudy) {
        this.commonStudy = commonStudy;
    }

    public CommonStudy getResearchStudy() {return commonStudy;}
    public String getUser() { return commonStudy.getResearcherName(); }
}
