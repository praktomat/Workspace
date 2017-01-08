package iterator;

import edu.kit.calendar.Date;
import edu.kit.sortedlist.SortedIterator;

public class FixedDeltaDateIterator implements SortedIterator<Date> {

    private Date startDate;
    private Date endDate;
    private int deltaYear;
    private int deltaMonth;
    private int deltaDay;

    // TODO:
    private int pointer;

    public FixedDeltaDateIterator(Date startDate, Date endDate, int deltaYear, int deltaMonth, int deltaDay) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.deltaYear = deltaYear;
        this.deltaMonth = deltaMonth;
        this.deltaDay = deltaDay;
        this.pointer = -1;
    }

    @Override
    public boolean hasNext() {
        Date increment = getIncrement(pointer + 1);

        return endDate == null || increment.isBefore(endDate) || increment.isEqual(endDate);
    }

    @Override
    public Date next() {
        if (hasNext()) {
            pointer++;
            return getIncrement(pointer);
        } else
            return null;
    }

    /**
     * 
     * @return
     */
    private Date getIncrement(int repeat) {

        Date result = startDate;

        for (int i = 0; i < repeat; i++)
            result = result.plus(new Date(deltaYear, deltaMonth, deltaDay));

        return result;
    }

}
