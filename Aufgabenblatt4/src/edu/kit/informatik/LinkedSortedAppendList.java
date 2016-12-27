package edu.kit.informatik;

/**
 * 
 * Creates a linked list that is sorted
 * 
 * @author Julien Midedji
 *
 * @param <T> Variable type to sort
 */
class LinkedSortedAppendList<T extends Comparable<T>> implements SortedAppendList {

	private Cell first;

	/**
	 * Initialize empty List
	 */
	LinkedSortedAppendList() {
		first = null;
	}

	/**
	 * 
	 * A Cell represents a single element in the
	 * list holding the value and a reference to the next element
	 *
	 * @param <T> type of value
	 */
	private class Cell {
		private Comparable content;
		private Cell next;

		private Cell(Comparable content, Cell next) {
			this.content = content;
			this.next = next;
		}
	}

	/**
	 * An Iterator can cycle through the list
	 *
	 */
	private class Iterator implements SortedIterator {

		private int pointer;

		private Iterator() {
			pointer = 0;
		}

		@Override
		public boolean hasNext() {
			Cell current = getElement(pointer);

			if (current.next != null)
				return true;
			else
				return false;
		}

		@Override
		public Comparable next() {

			Cell current = getElement(pointer);

			if (current == null) {
				System.out.println("No such element");
				return null;
			}

			pointer++;
			return current.content;

		}

	}

	/**
	 * Returns the element at the specific position
	 * in the list
	 * 
	 * @param index Position of element
	 * @return Element at position
	 */
	private Cell getElement(int index) {
		Cell current = first;

		for (int i = 0; i < index; i++)
			current = current.next;

		return current;
	}

	/**
	 * Adds an element to list in correct order
	 * 
	 * @param element to add
	 */
	@Override
	public void addSorted(Comparable element) {
		
		// Create new element 
		Cell newCell = new Cell(element, null);
		
		// Pointer element
		Cell current = first;

		// Initialize first element
		if (current == null) {
			first = newCell;

		// Initialize elements after first
		} else {
			while (current.next != null)
				current = current.next;
			current.next = newCell;
		}
	}

	@Override
	public SortedIterator iterator() {
		return new Iterator();
	}

	@Override
	public String toString() { // TODO: Remove
		String str = first.content.toString();

		Cell current = first; // TODO: nice name

		while (current.next != null) {
			current = current.next;
			str += ", " + current.content.toString();
		}

		return str;
	}
}
