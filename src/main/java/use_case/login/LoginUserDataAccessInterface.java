package use_case.login;

import entity.User;

/**
 * DAO for the Login Use Case.
 */
public interface LoginUserDataAccessInterface {

    /**
     * Checks if the given email exists.
     * @param email the email to look for
     * @return true if a user with the given email exists; false otherwise
     */
    boolean existsByName(String email);

    /**
     * Saves the user.
     * @param user the user to save
     */
    void save(User user);

    /**
     * Returns the user with the given email.
     * @param email the email to look up
     * @return the user with the given username
     */
    User get(String email);

    /**
     * Sets current user.
     * @param name user's name.
     */
    void setCurrentUsername(String name);

    /**
     * Returns current user.
     * @return current user
     */
    String getCurrentUsername();

}
