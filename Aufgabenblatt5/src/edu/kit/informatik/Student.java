package edu.kit.informatik;

/**
 * Represents a student account.
 * 
 * @author Julien Midedji
 */
public class Student extends User {
    
    /**
     * Keeps count of current amount of instances.
     */
    private static int amount = 0;
    
    /**
     * Student identification
     */
    private final String id = generateMatrNumber();
    
    /**
     * Keeps journal of all credits this student has
     */
    private PerformanceRecord record;
    
    /**
     * Creates a new student account.
     * 
     * @param firstName first name
     * @param lastName last name
     */
    Student(String firstName, String lastName) {
        super(firstName, lastName);
    }

    /**
     * Returns a student's identifaction which is his matriculation number.
     * 
     * @return id the identifier
     */
    protected String getId() {
        return id;
    }
    
    // TODO: "Ist für eine Vorlesung noch keine Note eingetragen, 
    // so wird diese Vorlesung nicht bei der Berechnung der Durchschnittsnote 
    // eines Moduls beachtet"
    
    protected int getOverallAverageGrade() {
        return -1;
    }
    
    /**
     * Creates a new unique matriculation number for this student account.
     * 
     * @return unique 6-digit matriculation number
     */
    private String generateMatrNumber() {
        return String.format("%06d", ++amount); // TODO: amount > 999999 ?
    }
}
