package edu.kit.calendar;

public class CalendarManagement {

	private Calendar calendar;
	
	// TODO: Use sorted list here
	
	private CalendarManagement() {
		calendar = new Calendar();
	}
	
	public static void main(String[] args) {

		System.out.println("add appointment".length());
		
		while(true) {
			String input = Terminal.readLine();
			
			if(input.startsWith("add appointment")) { // TODO: Use enum for commands
				
				System.out.println(input.substring(16, input.length()));
				
			}else if(true) {
				
			}
		}
		
	}

}
