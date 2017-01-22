
package edu.kit.informatik.sorting;

/**
 * An unmodifiable, filtered view of a collection.
 * 
 * @author  Tobias Bachert
 * @version 1.01, 2016/12/18
 * 
 * @param   <E> element type parameter
 */
final class FilteredListView<E> implements SortedAppendList<E> {
    
    private final SortedAppendList<E> source;
    private final Predicate<? super E> filter;
    
    /**
     * Constructs a new filtered view of the specified source collection.
     * 
     * @param  source the source collection
     * @param  filter the filter to apply
     * @throws NullPointerException if {@code source} or {@code filter} is {@code null}
     */
    FilteredListView(
            final SortedAppendList<E> source,
            final Predicate<? super E> filter) {
        ////
        this.source = Util.requireNonNull(source);
        this.filter = Util.requireNonNull(filter);
    }
    
    @Override
    public void addSorted(
            final E element) {
        ////
        throw new UnsupportedOperationException();
    }
    
    @Override
    public SortedIterator<E> iterator() {
        ////
        return new FilteredIterator<>(Util.requireNonNull(source.iterator()), filter);
    }
    
    @Override
    public void forEach(
            final Consumer<? super E> consumer) {
        ////
        Util.requireNonNull(consumer);
        
        source.forEach(value -> {
            if (filter.test(value))
                consumer.accept(value);
        });
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
        Util.requireNonNull(filter);
        
        final Predicate<? super E> thisFilter = this.filter;
        return new FilteredListView<>(source, value -> thisFilter.test(value) && filter.test(value));
    }
    
    @Override
    public String toString() {
        ////
        return Util.toString(this);
    }
    
    private static final class FilteredIterator<E> implements SortedIterator<E> {
        
        private SortedIterator<E> source;
        private Predicate<? super E> filter;
        private boolean present;
        private E value;
        
        FilteredIterator(
                final SortedIterator<E> source,
                final Predicate<? super E> filter) {
            ////
            assert source != null;
            assert filter != null;
            
            this.source = source;
            this.filter = filter;
        }
        
        @Override
        public boolean hasNext() {
            ////
            if (!present && source != null) {
                do {
                    if (!source.hasNext()) {
                        source = null;
                        filter = null;
                        value  = null;
                        break;
                    }
                    value = source.next();
                    present = filter.test(value);
                } while (!present);
            }
            return present;
        }
        
        @Override
        public E next() {
            ////
            if (!hasNext())
                throw new IllegalStateException();
            
            final E tmp = value;
            present = false;
            value   = null;
            return tmp;
        }
    }
}
