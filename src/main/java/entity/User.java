package entity;

/**
 * The representation of a user in our program.
 */
public interface User {

    /**
     * Returns the email that user signed up with.
     * @return the username (which is email in our project) of the user.
     */
    String getName();

    /**
     *
     * @return password of the user
     */
    String getPassword();


}