package edu.kit.informatik;

/**
 * TODO: Javadoc
 * 
 * @author Julien Midedji
 */
public class PerformanceRecord {

    /*
     * List of modules attended.
     */
    private Module[] modules;
    
    /*
     * Corresponding list of marks granted
     * The n-th index in list points to the n-th value
     */
    private int[] marks;
    
    /**
     * Creates a new empty record sheet.
     */
    protected PerformanceRecord() {
        modules = new Module[1];
        marks = new int[1];
    }
    
    /**
     * Add an entry to the record
     * 
     * @param module module attended
     * @param mark mark received
     */
    public void addMark(Module module, int mark) { // TODO: module is null? mark is < 0?
        
        // Create a new record
        Module[] newModules = new Module[modules.length+1];
        int[] newCredits = new int[marks.length+1];

        // Copy old entries
        for(int i = 0; i < modules.length; i++)
            newModules[i] = modules[i];

        for(int i = 0; i < marks.length; i++)
            newCredits[i] = marks[i];
        
        // Add entries
        newModules[modules.length] = module;
        newCredits[modules.length] = mark;
    }
    
    /**
     * Returns the sum of all corresponding marks multiplied with their
     * respective module credit.
     * 
     * @return total credits
     */
    public int getTotalCredits() {
        
        // TODO: implement

        // Total credits possible of all attended lectures
        
        // Iterate through each module
        for(int i = 0; i < modules.length; i++) {
            
            
        }
        return -100;
    }
    
    /**
     * The maximum amount of credits possible with the
     * given modules in the record
     * 
     * @return maximum credits
     */
    // TODO: "Ist für eine Vorlesung noch keine Note eingetragen, 
    // so wird diese Vorlesung nicht bei der Berechnung der Durchschnittsnote 
    // eines Moduls beachtet"
    public int getMaximumCredits() {
        int maximum = 0;
        
        for(Module module : modules)
            maximum += module.getCredits();
        
        return maximum;
    }
    
}
