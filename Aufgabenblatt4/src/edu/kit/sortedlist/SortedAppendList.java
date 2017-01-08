package edu.kit.sortedlist;

/**
 * An interface for Objects that implement a flexible sorted list.
 * 
 * @author Julien Midedji
 * @param <T>
 *            type of compared values
 */
interface SortedAppendList<T extends Comparable<T>> {

    /**
     * Adds an element to list so that its correctly ordered
     * 
     * @param element
     *            to add
     */
    void addSorted(T element);

    /**
     * Returns a new iterator for the list
     * 
     * @return The iterator to cycle through list
     */
    SortedIterator<T> iterator();

}
