package interface_adapter.EditStudy;

import interface_adapter.ViewModel;

public class EditStudyViewModel extends ViewModel<EditStudyState> {

    public static final String STUDY_TITLE_LABEL = "Enter New Title";
    public static final String DETAILS_LABEL = "Enter New Details";

    public static final String EDIT_STUDY_BUTTON_LABEL = "EDIT Study";
    public static final String CANCEL_BUTTON_LABEL = "Cancel";

    public EditStudyViewModel() {
        super("editStudy");
        setState(new EditStudyState());
    }

}
