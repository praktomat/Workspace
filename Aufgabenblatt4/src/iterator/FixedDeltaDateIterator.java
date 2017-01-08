package iterator;

import edu.kit.calendar.Date;
import edu.kit.sortedlist.SortedIterator;

public class FixedDeltaDateIterator implements SortedIterator<Date> {

    @Override
    public boolean hasNext() {

        return false;
    }

    @Override
    public Date next() {

        return null;
    }
    
}
