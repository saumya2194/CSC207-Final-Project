package use_case.editStudy;

import entity.CommonStudy;

public class EditStudyInputData {
    private final CommonStudy newStudy;

    public EditStudyInputData(CommonStudy newStudy) {
        this.newStudy = newStudy;
    }

    CommonStudy getNewStudy() {return this.newStudy; }

}
