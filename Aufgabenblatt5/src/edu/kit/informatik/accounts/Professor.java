package edu.kit.informatik.accounts;

/**
 * Represents a professor account.
 * 
 * @author Julien Midedji
 */
public class Professor extends User implements Comparable<Professor> {

    /**
     * The professor's associate chair
     */
    private final Chair chair;

    /**
     * Creates a new professor account.
     * 
     * @param firstName
     *            first name
     * @param lastName
     *            last name
     */
    public Professor(String firstName, String lastName, Chair chair) {
        super(firstName, lastName);
        this.chair = chair;
    }

    /**
     * Returns a professor's identifaction which is his first name and last
     * name.
     * 
     * @return first name and last name with one space in between.
     */
    @Override
    public String getId() {
        return getFirstName() + " " + getLastName();
    }

    /**
     * Compares professors according to first name, then last name, then chair
     * name
     * 
     * @param other
     *            professor to compare to.
     * @return negative if this precedes other lexicographically. Zero if they
     *         are identical, else positive
     */
    @Override
    public int compareTo(Professor user) {

        // Check first name
        int diff = getFirstName().compareTo(user.getFirstName());
        if (diff != 0)
            return diff;

        // Check last name
        diff = getLastName().compareTo(user.getLastName());
        if (diff != 0)
            return diff;

        // Check chair name
        diff = chair.getName().compareTo(((Professor) user).getChair().getName());
        if (diff != 0)
            return diff;

        return 0;
    }

    /**
     * Returns the Chair object this professor belongs to
     * 
     * @return academic chair object
     */
    public Chair getChair() {
        return chair;
    }
}
