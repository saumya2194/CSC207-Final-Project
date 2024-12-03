package interface_adapter.enter_id;

import interface_adapter.ViewModel;

public class EnterIDViewModel extends ViewModel<EnterIDState> {
    public static final String ID_LABEL = "Enter Experiment ID:";
    public static final String ID_CONFIRM_BUTTON_LABEL = "Confirm";
    public static final String ID_CANCEL_BUTTON_LABEL = "Cancel";

    public EnterIDViewModel() {
        super("enter id");
        setState(new EnterIDState());
    }
}
