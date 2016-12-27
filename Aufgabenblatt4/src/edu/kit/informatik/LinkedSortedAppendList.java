package edu.kit.informatik;

/**
 * 
 * Creates a linked list that is sorted
 * 
 * @author Julien Midedji
 *
 * @param <T>
 *            Variable type to sort
 */
class LinkedSortedAppendList<T extends Comparable<T>> implements SortedAppendList<T> {

	/**
	 * Starting element
	 */
	private Cell head;

	/**
	 * Initialize empty List
	 */
	LinkedSortedAppendList() {
		head = null;
	}

	/**
	 * 
	 * A Cell represents a single element in the list holding the value and a
	 * reference to the next element
	 *
	 * @param <T>
	 *            type of value
	 */
	private class Cell {
		private T content;
		private Cell prev;
		private Cell next;

		private Cell(T content, Cell prev, Cell next) {
			this.content = content;
			this.prev = prev;
			this.next = next;
		}
		
		@Override
		public String toString() { //TODO: Remove
			
			String nextStr;
			String prevStr;
			
			if(next == null)
				nextStr = "null";
			else
				nextStr = next.content.toString();
			
			if(prev == null)
				prevStr = "null";
			else
				prevStr = prev.content.toString();
			
			return "[<< " + prevStr + " << | " + content.toString() + " | >> " + nextStr + " >>]";
		}
	}

	/**
	 * An Iterator can cycle through the list
	 *
	 */
	private class Iterator implements SortedIterator<T> {

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
		public T next() {

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
	 * Returns the element at the specific position in the list
	 * 
	 * @param index
	 *            Position of element
	 * @return Element at position
	 */
	private Cell getElement(int index) {
		Cell current = head;

		for (int i = 0; i < index; i++)
			current = current.next;

		return current;
	}

	/**
	 * Adds an element to list in correct order
	 * 
	 * @param element
	 *            to add
	 */
	@Override
	public void addSorted(T element) {

		// Pointer element
		Cell current = head;

		// Initialize head element
		if (current == null) {
			head = new Cell(element, null, null);

			// Initialize elements after head was initialized
		} else {

			// Iterate through list until
			while(current.next != null) {
				
				// When new element is lower, put it in
				if (element.compareTo(current.content) < 0) {
	
					// Special case: New element needs to be head
					// Need to change head element
					if (current == head) {
						Cell temp = head;
						head = new Cell(element, null, temp);
	
					// Change chain of cells
					} else {
						Cell newElement = new Cell(element, current.prev, current.next);
						current.prev.next = newElement;
						current.next.prev = newElement; // TODO: Yup :P
					}
				}
				
				// When new element is higher, continue down the list
				if(element.compareTo(current.content) >= 0) {
					current = current.next;
				}
			}
			
			// Reached end
			if(current.next == null)
				current.next = new Cell(element, current, null);

			/*// Create new element
			Cell newCell = new Cell(element, null, null);
			
			while (current.next != null) {

				System.out.println("CHECKING: " + element.toString() + " with " + current.content.toString());

				if (element.compareTo(current.content) < 0)
					System.out.println("LOWER");

				if (element.compareTo(current.content) == 0)
					System.out.println("SAME");

				if (element.compareTo(current.content) > 0)
					System.out.println("HIGHER");

				current = current.next;
			}

			current.next = newCell;*/
		}
	}

	@Override
	public SortedIterator<T> iterator() {
		return new Iterator();
	}

	@Override
	public String toString() { // TODO: Remove
		String str = head.content.toString();

		Cell current = head; // TODO: nice name

		while (current.next != null) {
			current = current.next;
			str += ", " + current.content.toString();
		}

		return str;
	}
}
