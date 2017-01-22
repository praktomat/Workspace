package edu.kit.informatik;

public class Chair {

    private final String name;
    private Professor[] staff;
    
    protected Chair(String name, Professor[] staff) { // TODO: check if staff is null
        this.name = name;
        this.staff = staff;
    }
    
    public String getName() {
        return name;
    }
}
