
package sorting;

/**
 * An iterator that returns elements in a sorted order.
 * 
 * <p>The order of the elements is defined by their {@linkplain Comparable#compareTo(Object) natural order}.
 * 
 * @author  Tobias Bachert
 * @version 1.00, 2016/11/24
 * 
 * @param   <E> type parameter
 */
public interface SortedIterator<E> {
    
    /**
     * Returns whether the iterator contains more elements.
     * 
     * @return {@code true} if the iterator contains more elements, {@code false} otherwise
     */
    boolean hasNext();
    
    /**
     * Returns the next element of the iterator.
     * 
     * @return the next element
     * @throws IllegalStateException if no more elements are present
     */
    E next();
}
