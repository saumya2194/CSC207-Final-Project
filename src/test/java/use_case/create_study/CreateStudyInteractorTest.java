package use_case.create_study;

import data_access.InMemoryExperimentDataAccessObject;
import entity.CommonStudyFactory;
import entity.Study;
import entity.StudyFactory;
import org.junit.jupiter.api.Test;
import use_case.createstudy.*;
import java.time.LocalDateTime;


import static org.junit.jupiter.api.Assertions.*;

public class CreateStudyInteractorTest {

    @Test
    void successTest() {
        CreateStudyInputData inputData = new CreateStudyInputData("Psych Experiment", "For people in undergrad studies", "UofT");
        CreateStudyDataAccessInterface studyRepository = new InMemoryExperimentDataAccessObject();

        // This creates a successPresenter that tests whether the test case is as we expect.
        CreateStudyOutputBoundary successPresenter = new CreateStudyOutputBoundary() {
            @Override
            public void prepareSuccessView(CreateStudyOutputData study) {
                // 2 things to check: the output data is correct, and the user has been created in the DAO.
                assertEquals("Psych Experiment", (study.getTitle()));
                assertTrue(studyRepository.existsByName("Psych Experiment"));
            }

            @Override
            public void prepareFailView(String error) {
                fail("Use case failure is unexpected.");
            }

            @Override
            public void switchToHomepageView() {
                //This is expected
            }

        };

        CreateStudyInputBoundary interactor = new CreateStudyInteractor(studyRepository, successPresenter, new CommonStudyFactory());
        interactor.execute(inputData);
    }

    @Test
    void failureDetailsTest() {
        String long_string = "a".repeat(252);
        CreateStudyInputData inputData = new CreateStudyInputData("Dao", long_string, "UofT");
        CreateStudyDataAccessInterface userRepository = new InMemoryExperimentDataAccessObject();

        // This creates a presenter that tests whether the test case is as we expect.
        CreateStudyOutputBoundary failurePresenter = new CreateStudyOutputBoundary() {
            @Override
            public void prepareSuccessView(CreateStudyOutputData user) {
                // this should never be reached since the test case should fail
                fail("Use case success is unexpected.");
            }

            @Override
            public void prepareFailView(String error) {
                assertEquals("Passwords don't match.", error);
            }

            @Override
            public void switchToHomepageView() {
                // This is expected
            }
        };

        CreateStudyInputBoundary interactor = new CreateStudyInteractor(userRepository, failurePresenter, new CommonStudyFactory());
        interactor.execute(inputData);
    }

    @Test
    void failureUserExistsTest() {
        CreateStudyInputData inputData = new CreateStudyInputData("Paul", "password", "wrong");
        CreateStudyDataAccessInterface studyRepository = new InMemoryExperimentDataAccessObject();

        // Add Paul to the repo so that when we check later they already exist
        StudyFactory factory = new CommonStudyFactory();
        Study study = factory.create("uoft", "hihi", "dwadw");
        studyRepository.save(study);

        // This creates a presenter that tests whether the test case is as we expect.
        CreateStudyOutputBoundary failurePresenter = new CreateStudyOutputBoundary() {
            @Override
            public void prepareSuccessView(CreateStudyOutputData user) {
                // this should never be reached since the test case should fail
                fail("Use case success is unexpected.");
            }

            @Override
            public void prepareFailView(String error) {
                assertEquals("User already exists.", error);
            }

            @Override
            public void switchToHomepageView() {
                // This is expected
            }
        };

        CreateStudyInputBoundary interactor = new CreateStudyInteractor(studyRepository, failurePresenter, new CommonStudyFactory());
        interactor.execute(inputData);
    }
}