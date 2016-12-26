package edu.kit.informatik;

/**
 * 
 * @author Julien Midedji
 *
 * @param <T> type of values that are iterated
 */
interface SortedIterator<T extends Comparable<T>> {

	boolean hasNext();
	
	T next();
}
