package use_case.editStudy;

import use_case.createstudy.CreateStudyInputData;
import use_case.login.LoginInputBoundary;
import use_case.login.LoginInputData;

public interface EditStudyInputBoundary {
    /**
     * Executes the login use case.
     * @param editStudyInputData the input data
     */
    void execute(EditStudyInputData editStudyInputData);

    /**
     * Executes the switch to login view use case.
     */
    void switchToHomepageView();

}
