package iterator;

import edu.kit.sortedlist.SortedIterator;

public class UnionSortedIteratorOld<T extends Comparable<T>> implements SortedIterator<T> {

    private SortedIterator<T> iteratorA;
    private SortedIterator<T> iteratorB;

    private T previous;
    private boolean isA;

    public UnionSortedIteratorOld(SortedIterator<T> iteratorA, SortedIterator<T> iteratorB) {
        this.iteratorA = iteratorA;
        this.iteratorB = iteratorB;
    }

    @Override
    public boolean hasNext() {
        return iteratorA.hasNext() || iteratorB.hasNext();
    }

    @Override
    public T next() {
        // TODO: Printe die restlichen wenn eine Liste leer ist
        if (previous != null) {
            T result;
            
            if(!iteratorB.hasNext() && iteratorA.hasNext()) {
                T elementA = iteratorA.next();
                if(previous.compareTo(elementA) < 0) {
                    result = previous;
                    previous = iteratorA.next();
                    isA = true;
                    return result;
                }else{
                    return elementA;
                }
            }else if(!iteratorA.hasNext() && iteratorB.hasNext()) {
                
                T elementB = iteratorB.next();
                if(previous.compareTo(elementB) < 0) {
                    result = previous;
                    previous = iteratorB.next();
                    isA = false;
                    return result;
                }else{
                    return elementB;
                }
            }
            
            if (isA) {
                // TODO: Return greater method
                T elementB = iteratorB.next();
                if (previous.compareTo(elementB) < 0) {
                    result = previous;
                    previous = elementB;
                    isA = false;
                    return result;
                } else {
                    return elementB;
                }
            } else {
                T elementA = iteratorA.next();
                if (previous.compareTo(elementA) < 0) {
                    result = previous;
                    previous = elementA;
                    isA = true;
                    return result;
                } else {
                    return elementA;
                }
            }

        }

        T elementA = iteratorA.next();
        T elementB = iteratorB.next();

        if (elementA.compareTo(elementB) < 0) {
            previous = elementB;
            isA = false;
            return elementA;
        } else {
            previous = elementA;
            isA = true;
            return elementB;
        }
    }

}
