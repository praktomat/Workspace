
package edu.kit.informatik.sorting;

/**
 * Implementation of the {@linkplain SortedAppendList} interface.
 * 
 * @author  Tobias Bachert
 * @version 1.00, 2016/11/25
 * 
 * @param   <E> element type parameter
 */
public final class LinkedSortedAppendList<E extends Comparable<? super E>> implements SortedAppendList<E> {
    
    private int     size;
    private Cell<E> head;
    private Cell<E> middle;
    
    /**
     * Constructs an empty {@code LinkedSortedAppendList}.
     */
    public LinkedSortedAppendList() {
        ////
    }
    
    @Override
    public void addSorted(
            final E element) {
        ////
        Util.requireNonNull(element);
        
        if (head == null) {
            insertFirst(element);
        } else {
            insert(element);
        }
    }
    
    private void insertFirst(
            final E element) {
        ////
        assert head == null && middle == null && size == 0;
        middle = head = new Cell<>(element, null, null);
        size++;
    }
    
    private void insert(
            final E element) {
        ////
        final int midPos = size - 1 >>> 1;
        int insPos = 0;
        int refPos = midPos;
        Cell<E> ref = middle;
        
        for (int high = size - 1; insPos <= high;) {
            final int middle = insPos + high >>> 1;
            for (; refPos < middle; refPos++, ref = ref.next) { /**/ }
            for (; refPos > middle; refPos--, ref = ref.prev) { /**/ }
            if (element.compareTo(ref.value) < 0) {
                high = middle - 1;
            } else {
                insPos = middle + 1;
            }
        }
        
        if (insPos == refPos) { // insPos == refPos <=> ref.value > element
            insertBefore(element, ref);
        } else {
            insertBehind(element, ref);
        }
        
        if (insPos <= midPos) { // Adjusting middle to size >>> 1, insPos == midPos <=> insPos == refPos
            if ((size & 1) != 0)
                middle = middle.prev;
        } else {
            if ((size & 1) == 0)
                middle = middle.next;
        }
        size++;
    }
    
    private void insertBefore(
            final E element,
            final Cell<E> ref) {
        ////
        final Cell<E> n = new Cell<>(element, ref, ref.prev);
        ref.prev = n;
        if (n.prev != null) {
            n.prev.next = n;
        } else {
            head = n;
        }
    }
    
    private void insertBehind(
            final E element,
            final Cell<E> ref) {
        ////
        final Cell<E> n = new Cell<>(element, ref.next, ref);
        ref.next = n;
        if (n.next != null)
            n.next.prev = n;
    }
    
    @Override
    public SortedIterator<E> iterator() {
        ////
        return new Iterator<>(head);
    }
    
    @Override
    public void forEach(
            final Consumer<? super E> consumer) {
        ////
        Util.requireNonNull(consumer);
        
        for (Cell<E> cr = head; cr != null; cr = cr.next)
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
        Cell<E> prev;
        
        Cell(final E value, final Cell<E> next, final Cell<E> prev) {
            this.value = value;
            this.next  = next;
            this.prev  = prev;
        }
    }
}
