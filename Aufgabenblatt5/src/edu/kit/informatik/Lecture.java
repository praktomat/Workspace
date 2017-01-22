package edu.kit.informatik;

/**
 * TODO: Javadoc
 * 
 * @author Julien Midedji
 */
public class Lecture extends Course {

    /*
     * The module this lecture is part of
     */
    private Module module;
    
    /*
     * The professor that holds this lecture
     */
    private Professor lecturer;
    
    /*
     * The amount of total credits this course grants
     */
    private int credits;
    
    /**
     * Creates a new lecture that is part of a module
     * 
     * @param name name of the lecture
     * @param credits total amount of credits this course grants
     * @param module what this lecture is part of
     * @param lecturer the professor that holds this lecture
     */
    protected Lecture(String name, int credits, Module module, Professor lecturer) {
        super(name);
        this.credits = credits; // TODO: h�chstens 9 leistungspunkte
        this.module = module;
        this.lecturer = lecturer;
    }

    /**
     * Return the amount of credit this lecture grants in total
     */
    @Override
    protected int getCredits() {
        return credits;
    }
}
