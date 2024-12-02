package use_case.editStudy;

import use_case.login.LoginInputBoundary;
import use_case.login.LoginInputData;

public interface EditStudyInputBoundary {
    /**
     *
     */
    void execute(EditStudyInputData editStudyInputData);
}
