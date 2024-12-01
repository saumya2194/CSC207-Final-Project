package use_case.editStudy;

/**
 * Output data for EditStudy usecase.
 */
public class EditStudyOutputData {

    private final boolean useCaseFailed;

    public EditStudyOutputData(boolean useCaseFailed) {
        this.useCaseFailed = useCaseFailed;
    }
}
