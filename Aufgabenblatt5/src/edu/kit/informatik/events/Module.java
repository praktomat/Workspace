package edu.kit.informatik.events;

/**
 * TODO: Javadoc
 * 
 * @author Julien Midedji
 */
public class Module extends Course {
    
    private Lecture[] lectures;
    
    /**
     * Creates a new module. Module is a set of lectures.
     * 
     * @param name Name of module
     */
    public Module(String name, Lecture[] lectures) {
        super(name);
        this.lectures = lectures; //TODO: Maximum credits allowed: 45 
    }

    /**
     * Adds the total and returns the total credit of its lectures 
     * 
     * @return total credits this module grants
     */
    @Override
    public int getCredits() {
        int totalCredits = 0;
        
        for(Lecture lecture : lectures)
            totalCredits += lecture.getCredits();
        
        return totalCredits;
    }
    
    public Lecture[] getLectures() {
        return lectures;
    }

}
