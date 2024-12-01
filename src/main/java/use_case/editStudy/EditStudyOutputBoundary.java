package use_case.editStudy;

import use_case.login.LoginOutputData;

public interface EditStudyOutputBoundary {


    void prepareSuccessView(EditStudyOutputData response);

    /**
     * Prepares the failure view for the Login Use Case.
     * @param errorMessage the explanation of the failure
     */
    void prepareFailView(String errorMessage);
}
