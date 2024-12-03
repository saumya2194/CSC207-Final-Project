package interface_adapter.createstudy;

import interface_adapter.ViewModel;

/**
 * View Model for create Study View.
 */
public class CreateStudyViewModel extends ViewModel<CreateStudyState> {

    public static final String TITLE_LABEL = "Sign Up View";
    public static final String STUDY_TITLE_LABEL = "Select Title";
    public static final String DETAILS_LABEL = "Enter Details";

    public static final String CREATE_STUDY_BUTTON_LABEL = "Create Study";
    public static final String CANCEL_BUTTON_LABEL = "Cancel";

    public CreateStudyViewModel() {
        super("create study");
        setState(new CreateStudyState());
    }
}
