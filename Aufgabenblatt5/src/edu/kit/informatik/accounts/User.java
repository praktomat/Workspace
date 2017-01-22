package edu.kit.informatik.accounts;

/**
 * @TODO: MIssing javadoc
 * 
 * @author Julien Midedji
 */
public abstract class User {

    /**
     * First name of User.
     */
    private final String firstName;

    /**
     * Last name of User.
     */
    private final String lastName;

    /**
     * Creates an account
     * 
     * @param firstName
     *            first name
     * @param lastName
     *            last name
     * @param id
     *            identifaction
     */
    protected User(String firstName, String lastName) {
        this.firstName = firstName; // TODO: Name should have atleast 1 letter
        this.lastName = lastName;
    }

    /**
     * Should return a consistent and unique identifier for this object
     * 
     * @return identification for this User
     */
    public abstract String getId();

    /**
     * Returns first name
     * 
     * @return first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Returns last name
     * 
     * @return last name
     */
    public String getLastName() {
        return lastName;
    }
}
