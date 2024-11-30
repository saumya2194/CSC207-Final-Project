package use_case.load_homepage;

import entity.CommonUser;

public class LoadHomepageInputData {
    // do we need username and password? or user


    private final CommonUser user;

    // collection for your experiments

    public LoadHomepageInputData(CommonUser user){
        this.user = user;
    }

    public CommonUser getUser() {
        return user;
    }

    // do we need a setter?

}
