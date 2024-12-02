package use_case.view_experiment;

import data_access.InMemoryExperimentDataAccessObject;
import entity.StudyFactory;
import entity.CommonStudyFactory;
import entity.Study;
import entity.CommonStudy;
import data_access.InMemoryUserDataAccessObject;
import entity.CommonUserFactory;
import entity.User;
import entity.UserFactory;
import org.junit.jupiter.api.Test;
import use_case.createstudy.CreateStudyDataAccessInterface;
import use_case.signup.*;

import javax.swing.text.View;

import static org.junit.jupiter.api.Assertions.*;

class ViewExperimentInteractorTest {

    @Test
    void successTest() {
        StudyFactory factory = new CommonStudyFactory();
        CommonStudy study = factory.create("hello kitty", "smol experiment", "404");
        InMemoryExperimentDataAccessObject studyRepository = new InMemoryExperimentDataAccessObject();
        studyRepository.save(study);

        ViewExperimentInputData inputData = new ViewExperimentInputData(study);
        // This creates a successPresenter that tests whether the test case is as we expect.
        ViewExperimentOutputBoundary successPresenter = new ViewExperimentOutputBoundary() {
            @Override
            public void prepareSuccessView(ViewExperimentOutputData OutputData) {
                assertSame(studyRepository.getResearchStudy(study.getId()), study);
            }


            @Override
            public void prepareFailView(String error) {
                fail("Use case failure is unexpected.");
            }
        };

        ViewExperimentInputBoundary interactor = new ViewExperimentInteractor(studyRepository, successPresenter);
        interactor.execute(inputData);
    }
}