package interface_adapter.EditStudy;

import interface_adapter.ViewModel;

public class EditStudyViewModel extends ViewModel<EditStudyState> {

    public EditStudyViewModel() {
        super("editStudy");
        setState(new EditStudyState());
    }

}
