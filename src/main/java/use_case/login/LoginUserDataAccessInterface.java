package use_case.login;

import entity.User;

/**
 * DAO for the Login Use Case.
 */
public interface LoginUserDataAccessInterface {

    /**
     * Checks if the given username exists.
     * @param username the username to look for
     * @return true if a user with the given username exists; false otherwise
     */
    boolean existsByName(String username);

    /**
     * Saves the user.
     * @param user the user to save
     */
    void save(User user);

    /**
     * Returns the user with the given username.
     * @param username the username to look up
     * @return the user with the given username
     */
    User get(String email);

    /**
     * Sets current user.
     * @param name user's name.
     */
    void setCurrentUser(String name);

    /**
     * Returns current user.
     * @return current user
     */
    String getCurrentUser();

    void setCurrentEmail(String name);
}
