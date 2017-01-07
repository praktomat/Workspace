package edu.kit.calendar;

public class Main {

	public static void main(String[] args) {
		
	    DateTime dt = new DateTime(new Date(2016, 12, 15), new Time(12, 23, 1));
        Appointment a1 = new Appointment("Demo", dt, dt.plusDays(20));
        
        System.out.println(DateUtil.parseAppointment(a1.getFrom() + " " + a1.getTo() + " " + a1.getName()));
	    
	}
}

// C.1.2 done
