package edu.kit.informatik;

/**
 * TODO: Javadoc
 * @author Julien Midedji
 */
public abstract class Course {

    /**
     * Name of the course
     */
    private String name;
    
    /**
     * Amount of credit this course grants
     */
    private int credit;
    
    /**
     * Keeps count of current amount of instances.
     */
    private static int amount = 0;
}
