package interface_adapter.EditStudy;

import interface_adapter.ViewModel;
import interface_adapter.createstudy.CreateStudyState;

public class EditStudyViewModel extends ViewModel<EditStudyState> {

        public static final String TITLE_LABEL = "Edit Study View";
        public static final String STUDY_TITLE_LABEL = "Select Title";
        public static final String DETAILS_LABEL = "Enter Details";
        public static final String ID_LABEL = "Enter ID";

        public static final String CREATE_STUDY_BUTTON_LABEL = "Edit Study";
        public static final String CANCEL_BUTTON_LABEL = "Cancel";
    public static final String EDIT_STUDY_BUTTON_LABEL = "Edit Experiment";

    public EditStudyViewModel() {
            super("edit study");
            setState(new EditStudyState());
        }
}
