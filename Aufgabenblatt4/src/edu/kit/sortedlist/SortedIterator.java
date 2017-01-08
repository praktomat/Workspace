package edu.kit.sortedlist;

/**
 * An iterator over a specific list
 * 
 * @author Julien Midedji
 * @param <T>
 *            Type of values that are returned
 */
public interface SortedIterator<T extends Comparable<T>> {
    // TODO: Stay public?

    /**
     * @return Returns true if the list contains more elements ahead
     */
    boolean hasNext();

    /**
     * @return The next element in the list
     */
    T next();
}
