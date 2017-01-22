package edu.kit.informatik.events;

import edu.kit.informatik.accounts.Professor;

/**
 * TODO: Javadoc
 * 
 * @author Julien Midedji
 */
public class Lecture extends Course implements Comparable<Lecture> {

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
     * @param name
     *            name of the lecture
     * @param credits
     *            total amount of credits this course grants
     * @param module
     *            what this lecture is part of
     * @param lecturer
     *            the professor that holds this lecture
     */
    public Lecture(String name, int credits, Module module, Professor lecturer) {
        super(name);
        this.credits = credits; // TODO: höchstens 9 leistungspunkte
        this.module = module;
        this.lecturer = lecturer;
    }

    /**
     * Return the amount of credit this lecture grants in total
     */
    @Override
    public int getCredits() {
        return credits;
    }

    @Override
    public int compareTo(Lecture o) {
        // TODO Auto-generated method stub
        return 0;
    }
}
