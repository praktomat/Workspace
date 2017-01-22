package edu.kit.informatik.behindscenes;

import edu.kit.informatik.accounts.Student;

public class Main {

    /**
     * Arbeitsblatt briefing:
     * 
     * !!! Methodik macht 5 Punkte aus.
     *  - Fehlende Kommentierung
     *  - JavaDoc!
     *  - Variablenbezeichner
     *  - zu tiefe Verschachtelung
     *  
     *  - Falsches Exception Handling
     *  - Pokemon Exception
     *  
     *  - Gott Klassen
     *  - Konzeptlos
     *  - falscher Ansatz von Vererbung
     *  - falsche Kapselung
     *  
     * !!! Fehler mit "Error, " anfangen
     * 
     * !!! Terminal-Klasse nicht hochladen
     * 
     * 
     * 
     */
    
    public static void main(String[] args) {

        Student student = new Student("Julien", "Midedji");
        Student student2 = new Student("Julien", "Midedji");
        Student student3 = new Student("Julien", "Midedji");
        
    }

    // TODO: All construcotrs are currenly protected
    // Getter and Setter in abstract classes sind protected
    // TODO: Check all scopes, and fields by instantiating each class
    // TODO: Notenberechnung wurde übersprungen
}
