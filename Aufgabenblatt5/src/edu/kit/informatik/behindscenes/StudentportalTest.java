package edu.kit.informatik.behindscenes;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.kit.informatik.accounts.Chair;
import edu.kit.informatik.accounts.Professor;
import edu.kit.informatik.accounts.Student;
import edu.kit.informatik.accounts.User;
import edu.kit.informatik.events.Lecture;
import edu.kit.informatik.events.Module;

public class StudentportalTest {

    @Test
    // "welche sich der Einfachheit halber nur aus Kleinbuchstaben zusammensetzen"
    // "Der Name für einen Lehrstuhl setzt sich erneut nur aus Kleinbuchstaben zusammen"
    // "Der Name setzt sich hierbei wieder rein aus Kleinbuchstaben zusammen."
    public void testLowerCase() {
        
        // Student lower-case name
        User student = new Student("Hans", "Zimmer");
        String firstName = student.getFirstName();
        String lastName = student.getLastName();
        
        assertTrue("firstName should be lower-case but has upper-case letters", firstName.equals(firstName.toLowerCase()));
        assertTrue("lastName should be lower-case but has upper-case letters", lastName.equals(lastName.toLowerCase()));
        
        // Chair lower-case name
        Chair chair = new Chair("Informatik", null);
        String name = chair.getName();
        assertTrue("name should be lower-case but has upper-case letters", name.equals(name.toLowerCase()));
        
        // Professor lower-case name
        User professor = new Professor("Dieter", "Bohlen", chair);
        String first = professor.getFirstName();
        String last = professor.getLastName();

        assertTrue("firstName should be lower-case but has upper-case letters", first.equals(first.toLowerCase()));
        assertTrue("lastName should be lower-case but has upper-case letters", last.equals(last.toLowerCase()));
        
        // Module lower-case name
        Module module = new Module("Praktische Informatik", null);
        String moduleName = module.getName();
        assertTrue("name should be lower-case but has upper-case letters", moduleName.equals(moduleName.toLowerCase()));
        
        // Lecture lower-case name
        Lecture lecture = new Lecture("Programmieren", 5, module, (Professor) professor);
        String lectureName = lecture.getName();
        assertTrue("name should be lower-case but has upper-case letters", lectureName.equals(lectureName.toLowerCase()));
    }
    
    @Test
    // "Eine Matrikelnummer ist immer eine positive, sechsstellige, ganze Zahl"
    public void testMatrNumber() {

        // Student lower-case name
        User student = new Student("Hans", "Zimmer");
        String id = student.getId();
        
        assertTrue("student id should be length of 6 but is not", id.length()==6);
        assertTrue("student id should be positive but is not", Integer.parseInt(id)>0);
    }
    
    // Other Requirements:
    // "Hierbei haben Vorlesungen höchstens neun Leistungspunkte."
    // "Das heißt ein Modul darf in der Summe nie mehr als 45 Leistungspunkte beinhalten."
    
}
