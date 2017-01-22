package edu.kit.informatik;

/**
 * TODO: Javadoc
 * @author Julien Midedji
 */
public class Lecture extends Course {

    private Module module;
    private Professor lecturer;
    
    protected Lecture(Module module, Professor professor) {
        this.module = module;
        this.lecturer = professor;
    }
}
