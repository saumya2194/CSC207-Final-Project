package use_case.edit_profile;
import entity.User;
import entity.UserFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for EditProfileInteractor without using Mockito.
 */
class EditProfileInteractorTest {

    private EditProfileInteractor interactor;
    private TestUserDataAccess userDataAccess;
    private TestPresenter presenter;
    private TestUserFactory userFactory;

    @BeforeEach
    void setUp() {
        userDataAccess = new TestUserDataAccess();
        presenter = new TestPresenter();
        userFactory = new TestUserFactory();
        interactor = new EditProfileInteractor(userDataAccess, presenter, userFactory);
    }

    @Test
    void testExecute_SuccessfulEdit() {
        // Arrange
        String username = "testUser";
        String newPassword = "newPassword123";
        EditProfileInputData inputData = new EditProfileInputData(username, newPassword);

        // Act
        interactor.execute(inputData);

        // Assert
        // Verify user data access layer was called with the correct user
        assertNotNull(userDataAccess.changedUser);
        assertEquals(username, userDataAccess.changedUser.getName());
        assertEquals(newPassword, userDataAccess.changedUser.getPassword());

        // Verify presenter received the correct output
        assertNotNull(presenter.outputData);
        assertEquals(username, presenter.outputData.getUsername());
        assertFalse(presenter.outputData.isUseCaseFailed());
    }

    @Test
    void testExecute_FailureInDataAccess() {
        // Arrange
        String username = "testUser";
        String newPassword = "newPassword123";
        EditProfileInputData inputData = new EditProfileInputData(username, newPassword);

        userDataAccess.throwException = true; // Simulate a failure in data access

        // Act & Assert
        RuntimeException exception = assertThrows(RuntimeException.class, () -> interactor.execute(inputData));
        assertEquals("Data access failure", exception.getMessage());

        // Ensure presenter was not called on failure
        assertNull(presenter.outputData);
    }

    // ===== Test Doubles =====

    private static class TestUserDataAccess implements EditProfileUserDataAccessInterface {
        User changedUser = null;
        boolean throwException = false;

        @Override
        public void changePassword(User user) {
            if (throwException) {
                throw new RuntimeException("Data access failure");
            }
            this.changedUser = user;
        }
    }

    private static class TestPresenter implements EditProfileOutputBoundary {
        EditProfileOutputData outputData = null;
        String errorMessage = null;

        @Override
        public void prepareSuccessView(EditProfileOutputData outputData) {
            this.outputData = outputData;
        }

        @Override
        public void prepareFailView(String error) {
            this.errorMessage = error;
        }
    }

    private static class TestUser implements User {
        private final String username;
        private final String password;

        public TestUser(String username, String password) {
            this.username = username;
            this.password = password;
        }

        @Override
        public String getName() {
            return username;
        }

        @Override
        public String getPassword() {
            return password;
        }
    }

    private static class TestUserFactory implements UserFactory {
        @Override
        public User create(String username, String password) {
            return new TestUser(username, password);
        }
    }
}

