
package edu.kit.informatik.sorting;

/**
 * A sorted list.
 * 
 * @author  Tobias Bachert
 * @version 1.01, 2016/12/16
 * 
 * @param   <E> element type parameter
 */
public interface SortedAppendList<E> {
    
    /**
     * Adds the specified element to this list.
     * 
     * <p>All elements prior this element will be less than or equal to this element, all elements after this element
     * will be greater than this element. As a result the insertion order will be maintained for compared equal objects.
     * 
     * @param  element the element
     */
    void addSorted(
            final E element);
    
    /**
     * Returns an iterator that iterates over the elements of this list in encounter order.
     * 
     * @return the iterator
     */
    SortedIterator<E> iterator();
    
    /**
     * Applies the specified consumer to all elements of this list.
     * 
     * <p>This method behaves like
     * <blockquote><pre>
     * for (SortedIterator&lt;E&gt; it = iterator(); it.hasNext();)
     *     consumer.accept(it.next());</pre>
     * </blockquote>
     * 
     * @param  consumer the consumer
     * @throws NullPointerException if {@code consumer} is {@code null}
     */
    default void forEach(
            final Consumer<? super E> consumer) {
        ////
        Util.requireNonNull(consumer);
        
        for (final SortedIterator<E> it = iterator(); it.hasNext();)
            consumer.accept(it.next());
    }
    
    /**
     * Returns an unmodifiable view of this collection.
     * 
     * @return the view
     */
    default SortedAppendList<E> unmodifiable() {
        ////
        return new SortedAppendList<E>() {
            
            @Override
            public void addSorted(
                    final E element) {
                ////
                throw new UnsupportedOperationException();
            }
            
            @Override
            public SortedIterator<E> iterator() {
                ////
                return SortedAppendList.this.iterator();
            }
            
            @Override
            public void forEach(
                    final Consumer<? super E> consumer) {
                ////
                SortedAppendList.this.forEach(consumer);
            }
            
            @Override
            public SortedAppendList<E> unmodifiable() {
                ////
                return this;
            }
            
            @Override
            public SortedAppendList<E> filter(
                    final Predicate<? super E> filter) {
                ////
                return SortedAppendList.this.filter(filter);
            }
        };
    }
    
    /**
     * Returns an unmodifiable, filtered view of this collection.
     * 
     * @param  filter a stateless predicate to use for filtering
     * @return the filtered view
     */
    default SortedAppendList<E> filter(
            final Predicate<? super E> filter) {
        ////
        return new FilteredListView<>(this, filter);
    }
    
    /**
     * Represents an operation that accepts a single input argument and returns no result.
     * 
     * <p>This is a {@linkplain FunctionalInterface functional interface} whose functional method is {@link
     * #accept(Object)}.
     * 
     * @param <T> the type of the input argument of the operation
     */
    @FunctionalInterface
    interface Consumer<T> {
        
        /**
         * Performs this operation on the given argument.
         * 
         * @param value the input argument
         */
        void accept(
                final T value);
    }
    
    /**
     * Represents a predicate (boolean-valued function) of one argument.
     * 
     * <p>This is a {@linkplain FunctionalInterface functional interface} whose functional method is {@link
     * #test(Object)}.
     * 
     * @param <T> the type of the input argument of the predicate
     */
    @FunctionalInterface
    interface Predicate<T> {
        
        /**
         * Evaluates this predicate on the given argument.
         * 
         * @param  value the input argument
         * @return {@code true} if the input argument matches the predicate, otherwise {@code false}
         */
        boolean test(
                final T value);
    }
}
