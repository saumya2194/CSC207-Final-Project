package interface_adapter.view_experiment;

import entity.CommonStudy;
import use_case.view_experiment.ViewExperimentInputBoundary;
import use_case.view_experiment.ViewExperimentInputData;

public class ViewExperimentController {
    private final ViewExperimentInputBoundary view;

    public ViewExperimentController(ViewExperimentInputBoundary view) {
        this.view = view;
    }

    public void execute(CommonStudy study){
        ViewExperimentInputData inputData = new ViewExperimentInputData(study);
        view.execute(inputData);
    }

    public void emailExperimentDetails(String titleText, String detailsText) {
        // insert implementation for mailgun api
        // account details:
        // Full name: Null Pointers
        // company: Null Pointers
        // work email: nullpointers207@gmail.com
        // gmail password: nullpointers@CSC207
        // mailgun password: project@CSC207
        // mailgun API key: 8f8e0ac69af04e6b22def8c8c642e925-c02fd0ba-848071eb
        // resend API key: re_XYVE11ke_AgA3qMsCrfALPcfJV1ePc3LE
        view.emailExperimentDetails(titleText, detailsText);

    }
}
