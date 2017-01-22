package edu.kit.informatik.accounts;

import edu.kit.informatik.helper.PerformanceRecord;

/**
 * Represents a student account.
 * 
 * @author Julien Midedji
 */
public class Student extends User implements Comparable<Student> {

    /**
     * Keeps count of current amount of instances.
     */
    private static int amount = 0;

    /*
     * A matriculation number does not allow leading zeros
     */
    private static final int MATR_NUMBER_START = 100000;

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
     * @param firstName
     *            first name
     * @param lastName
     *            last name
     */
    public Student(String firstName, String lastName) {
        super(firstName, lastName);
    }

    /**
     * Returns a student's identifaction which is his matriculation number.
     * 
     * @return id the identifier
     */
    public String getId() {
        return id;
    }

    // TODO: "Ist für eine Vorlesung noch keine Note eingetragen,
    // so wird diese Vorlesung nicht bei der Berechnung der Durchschnittsnote
    // eines Moduls beachtet"

    public int getOverallAverageGrade() {
        return -1;
    }

    /**
     * Creates a new unique matriculation number for this student account.
     * 
     * @return unique 6-digit matriculation number
     */
    private String generateMatrNumber() {
        return String.format("%d", MATR_NUMBER_START + ++amount); // TODO:
                                                                  // amount >
                                                                  // 999999 ?
    }

    /**
     * Compares students ascending to their matriculation number.
     * 
     * @param other
     *            student to compare to.
     * @return negative if this matriculation number is before other, else
     *         positive.
     */
    @Override
    public int compareTo(Student other) {
        return getId().compareTo(other.getId());
    }
}
