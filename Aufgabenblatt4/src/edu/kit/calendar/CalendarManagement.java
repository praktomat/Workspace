package edu.kit.calendar;

public class CalendarManagement {

	private static Calendar calendar; // TODO: Can this stay static?
	
	private CalendarManagement() {
		calendar = new Calendar();
	}
	
	public static void main(String[] args) {

		//System.out.println("add appointment".length());
		
		while(true) {
			String input[] = Terminal.readLine().split(" ");
			
			switch(input[0]) {
			
			case "add": 
			    calendar.add(String.format("%s %s %s", input[2], input[3], input[4]));
			    break;
			    
			case "print":
			    
			    // "print appointments"
			    if(input.length == 2) {
			        
			        calendar.printAll();
			        
		        // "print appointments that start before <pointOfTime>"
			    }else if(input[3].equals("start")) {
			        
			        
			        
			    // "print appointments on <date>"
			    }else if(input[2].equals("on")) {

		        // "print appointments in interval <startDate> <endDate>"
                }else if(input[2].equals("in")) {
                    
                // "print appointments that conflict with <appointmentTitle>"
                }else if(input[3].equals("conflict")) {
                    
                }else {
                    System.out.println("Error in my code");
                }

			    break;
			
			case "quit":
                break;  
                
            default:
                System.out.println("Unknown command");
                break;
			
			}		
		}
	}
}
