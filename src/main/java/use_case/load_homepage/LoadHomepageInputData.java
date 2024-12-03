package use_case.load_homepage;


/**
 * Input Data for Load Homepage.
 */
public class LoadHomepageInputData {
    // do we need username and password? or user


    private final String user;

    // collection for your experiments

    public LoadHomepageInputData(String user) {
        this.user = user;
    }

    public String getUser() {
        return user;
    }


}
