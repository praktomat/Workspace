package edu.kit.informatik;

/**
 * 
 * An iterator over a specific list
 * 
 * @author Julien Midedji
 *
 * @param <T> Type of values that are returned
 */
interface SortedIterator<T extends Comparable<T>> {

	/**
	 * 
	 * @return Returns true if the list contains more elements ahead
	 */
	boolean hasNext();
	
	/**
	 * 
	 * @return The next element in the list
	 */
	T next();
}
