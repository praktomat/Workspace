package edu.kit.informatik.events;

/**
 * TODO: Javadoc
 * 
 * @author Julien Midedji
 */
public abstract class Course {

    /**
     * Name of the course
     */
    private final String name;

    /**
     * Keeps count of current amount of instances.
     */
    private static int amount = 0;

    /**
     * Every course gets an identification number
     */
    private final int id;

    /**
     * Creates a new Course that can be attended and grants credits for
     * completion.
     * 
     * @param name
     */
    protected Course(String name) {
        this.name = name;
        this.id = ++amount;
    }

    /**
     * Should return the amount of credit this course grants in total
     */
    public abstract int getCredits();
    
    /**
     * Returns tne name of the course
     * 
     * @return name of course
     */
    public String getName() {
        return name;
    }
    
    /**
     * Returns tne id of the course
     * 
     * @return id of course
     */
    public int getId() {
        return id;
    }
}
