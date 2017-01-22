
package sorting;

/**
 * Implementation of the {@linkplain SortedAppendList} interface.
 * 
 * @author  Tobias Bachert
 * @version 1.00, 2016/11/24
 * 
 * @param   <E> element type parameter
 * 
 */
@Deprecated
public final class SingleLinkedSortedList<E extends Comparable<? super E>> implements SortedAppendList<E> {
    
    private final Cell<E> head = new Cell<>(null, null);
    
    /**
     * Constructs an empty {@code SingleLinkedSortedList}.
     */
    public SingleLinkedSortedList() {
        ////
    }
    
    @Override
    public void addSorted(
            final E element) {
        ////
        Util.requireNonNull(element);
        
        Cell<E> cr = head;
        for (; cr.next != null && cr.next.value.compareTo(element) <= 0; cr = cr.next) { /**/ }
        cr.next = new Cell<>(element, cr.next);
    }
    
    @Override
    public SortedIterator<E> iterator() {
        ////
        return new Iterator<>(head.next);
    }
    
    @Override
    public void forEach(
            final Consumer<? super E> consumer) {
        ////
        Util.requireNonNull(consumer);
        
        for (Cell<E> cr = head.next; cr != null; cr = cr.next)
            consumer.accept(cr.value);
    }
    
    @Override
    public String toString() {
        ////
        return Util.toString(this);
    }
    
    private static final class Iterator<E> implements SortedIterator<E> {
        
        private Cell<E> pointer;
        
        Iterator(final Cell<E> initial) {
            pointer = initial;
        }
        
        @Override
        public boolean hasNext() {
            return pointer != null;
        }
        
        @Override
        public E next() {
            if (!hasNext())
                throw new IllegalStateException();
            
            final E val = pointer.value;
            pointer = pointer.next;
            return val;
        }
    }
    
    private static final class Cell<E> {
        
        final E value;
        Cell<E> next;
        
        Cell(final E value, final Cell<E> next) {
            this.value = value;
            this.next  = next;
        }
    }
}
