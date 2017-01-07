package edu.kit.sortedlist;

import edu.kit.calendar.Appointment;
import edu.kit.calendar.Date;
import edu.kit.calendar.DateTime;
import edu.kit.calendar.Time;

public class Main {
	public static void main(String[] args) {
	    
	    DateTime dt = new DateTime(new Date(2016, 12, 15), new Time(12, 23, 1));
        Appointment a1 = new Appointment("Sleep", dt, dt.plusDays(20));
        Appointment a2 = new Appointment("Hello World", dt, dt.plusDays(22));
        
        System.out.println(a2.toString() + " compared to \n" 
        + a1.toString() + " should be positive |||" + (a2.compareTo(a1)));
	}
}

// TODO: Check how to write javadoc for interfaces and inner classes
