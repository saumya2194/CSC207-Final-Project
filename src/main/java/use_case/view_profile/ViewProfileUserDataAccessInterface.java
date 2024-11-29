package use_case.view_profile;

import entity.User;

/**
 * The interface of the DAO for the Change Password Use Case.
 */
public interface ViewProfileUserDataAccessInterface {

    /**
     * Updates the system to record this user's password.
     * @param user the user whose password is to be updated
     */
    void changePassword(User user);
}
