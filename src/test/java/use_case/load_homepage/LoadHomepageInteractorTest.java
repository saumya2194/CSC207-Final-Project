package use_case.load_homepage;
import data_access.InMemoryExperimentDataAccessObject;
import entity.CommonStudy;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LoadHomepageInteractorTest {

    @Test
    public void successTest() {
        // Arrange
        LoadHomepageInputData inputData = new LoadHomepageInputData("testUser");
        InMemoryExperimentDataAccessObject dataAccessObject = new InMemoryExperimentDataAccessObject();

        // Create studies
        CommonStudy studyA = new CommonStudy("1", "Study A", "testUser");
        CommonStudy studyB = new CommonStudy("2", "Study B", "otherUser");

        // Add studies to DAO
        dataAccessObject.save(studyA);
        dataAccessObject.save(studyB);

        LoadHomepageOutputBoundary successPresenter = new LoadHomepageOutputBoundary() {
            @Override
            public void prepareSuccessView(LoadHomepageOutputData data) {
                // Assert
                assertEquals("testUser", data.getUser());
                assertArrayEquals(new CommonStudy[]{studyA, studyB}, data.getExperiments());
                assertArrayEquals(new CommonStudy[]{studyA}, data.getMyExperiments());
                assertFalse(data.isUseCaseFailed());
            }

            @Override
            public void prepareFailView(String error) {
                fail("Error view should not be invoked in success case.");
            }

            @Override
            public void switchToProfileView(String username) {
                assertEquals("testUser", username);
            }

            @Override
            public void switchToCreateStudyView(String username) {
                assertEquals("testUser", username);
            }

            @Override
            public void switchToEditExperimentView(String username) {
                assertEquals("testUser", username);
            }

            @Override
            public void switchToEnterIDView(String username) {
                assertEquals("testUser", username);
            }
        };

        LoadHomepageInteractor interactor = new LoadHomepageInteractor(successPresenter, dataAccessObject);

        // Act
        interactor.execute(inputData);

        // Invoke additional methods to ensure full coverage
        interactor.switchToProfileView("testUser");
        interactor.switchToCreateStudyView("testUser");
        interactor.switchToEditExperimentView("testUser");
        interactor.switchToEnterIDView("testUser");
    }

    @Test
    public void emptyDataTest() {
        // Arrange
        LoadHomepageInputData inputData = new LoadHomepageInputData("emptyUser");
        InMemoryExperimentDataAccessObject dataAccessObject = new InMemoryExperimentDataAccessObject();

        LoadHomepageOutputBoundary emptyPresenter = new LoadHomepageOutputBoundary() {
            @Override
            public void prepareSuccessView(LoadHomepageOutputData data) {
                // Assert
                assertEquals("emptyUser", data.getUser());
                assertArrayEquals(new CommonStudy[]{}, data.getExperiments());
                assertArrayEquals(new CommonStudy[]{}, data.getMyExperiments());
                assertFalse(data.isUseCaseFailed());
            }

            @Override
            public void prepareFailView(String error) {
                fail("Error view should not be invoked for empty data.");
            }

            @Override
            public void switchToProfileView(String username) {
                assertEquals("emptyUser", username);
            }

            @Override
            public void switchToCreateStudyView(String username) {
                assertEquals("emptyUser", username);
            }

            @Override
            public void switchToEditExperimentView(String username) {
                assertEquals("emptyUser", username);
            }

            @Override
            public void switchToEnterIDView(String username) {
                assertEquals("emptyUser", username);
            }
        };

        LoadHomepageInteractor interactor = new LoadHomepageInteractor(emptyPresenter, dataAccessObject);

        // Act
        interactor.execute(inputData);

        // Invoke additional methods to ensure full coverage
        interactor.switchToProfileView("emptyUser");
        interactor.switchToCreateStudyView("emptyUser");
        interactor.switchToEditExperimentView("emptyUser");
        interactor.switchToEnterIDView("emptyUser");
    }

    @Test
    public void errorViewTest() {
        // Arrange
        LoadHomepageInputData inputData = null; // Simulate a null input
        InMemoryExperimentDataAccessObject dataAccessObject = new InMemoryExperimentDataAccessObject();

        LoadHomepageOutputBoundary errorPresenter = new LoadHomepageOutputBoundary() {
            @Override
            public void prepareSuccessView(LoadHomepageOutputData data) {
                fail("Success view should not be invoked on null input.");
            }

            @Override
            public void prepareFailView(String error) {
                assertEquals("Input data is null.", error);
            }

            @Override
            public void switchToProfileView(String username) {
                fail("Switching views should not occur on error.");
            }

            @Override
            public void switchToCreateStudyView(String username) {
                fail("Switching views should not occur on error.");
            }

            @Override
            public void switchToEditExperimentView(String username) {
                fail("Switching views should not occur on error.");
            }

            @Override
            public void switchToEnterIDView(String username) {
                fail("Switching views should not occur on error.");
            }
        };

        LoadHomepageInteractor interactor = new LoadHomepageInteractor(errorPresenter, dataAccessObject);

        // Act & Assert
        assertThrows(NullPointerException.class, () -> interactor.execute(inputData));
    }
}
