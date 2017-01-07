package edu.kit.calendar;

import edu.kit.sortedlist.LinkedSortedAppendList;
import edu.kit.sortedlist.SortedIterator;

public class Calendar {
	
    LinkedSortedAppendList<Appointment> list;
    
	public Calendar() {
	    list = new LinkedSortedAppendList<>();
	}
	
	/**
	 * Adds entry to Calendar
	 * 
	 * <p>The input argument has to match the format:
     * <blockquote><pre>
     * &lt;from&gt; &lt;to&gt; &lt;name&gt;</pre>
     * </blockquote>
	 * 
	 * @param input the string of the entry
	 */
	public void add(String input) {
	    list.addSorted(DateUtil.parseAppointment(input));
	}

	/**
	 * Prints all entries to console
	 */
    public void printAll() {
        
        SortedIterator<Appointment> iterator = list.iterator();
        
        while(iterator.hasNext())
            Terminal.printLine(iterator.next());
    }
}
