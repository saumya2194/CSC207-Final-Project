package interface_adapter.load_homepage;

import entity.CommonStudy;
import entity.CommonUser;

public class HomepageState {

    private CommonStudy[] experiments = {};
    private CommonStudy[] myExperiments ={};
    private String username;

    public CommonStudy[] getExperiments() {
        return experiments;
    }

    public void setExperiments(CommonStudy[] experiments) {
        this.experiments = experiments;
    }

    public CommonStudy[] getMyExperiments() {
        return myExperiments;
    }

    public void setMyExperiments(CommonStudy[] myExperiments) {
        this.myExperiments = myExperiments;
    }

    public String getUsername() { return this.username;}

    public void setUsername(String username) { this.username = username; }

}
