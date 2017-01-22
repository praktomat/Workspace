package edu.kit.informatik.accounts;

public class Chair {

    private final String name;
    private Professor[] staff;
    
    public Chair(String name, Professor[] staff) { // TODO: check if staff is null
        this.name = name;
        this.staff = staff;
    }
    
    public String getName() {
        return name;
    }
}
