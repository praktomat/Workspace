package edu.kit.informatik;

/**
 * Represents a professor account.
 * 
 * @author Julien Midedji
 */
public class Professor extends User {

    /**
     * The professor's associate chair
     */
    private final Chair chair;
    
    /**
     * Creates a new professor account.
     * 
     * @param firstName first name
     * @param lastName last name
     */
    protected Professor(String firstName, String lastName, Chair chair) {
        super(firstName, lastName);
        this.chair = chair; 
    }

    /**
     * Returns a professor's identifaction which is his first name and last name.
     * 
     * @return first name and last name with one space in between. 
     */
    @Override
    protected String getId() {
        return getFirstName() + " " + getLastName();
    }

}
