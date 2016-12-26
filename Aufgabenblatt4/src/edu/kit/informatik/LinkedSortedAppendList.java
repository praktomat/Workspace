package edu.kit.informatik;

class LinkedSortedAppendList<T extends Comparable<T>> implements SortedAppendList {

	private Cell<T> first;

	LinkedSortedAppendList() {
		first = null;
	}

	private class Cell<T> {
		T content;
		Cell<T> next;

		Cell(T content, Cell<T> next) {
			this.content = content;
			this.next = next;
		}
	}

	private class Iterator implements SortedIterator {

		private int pointer;

		Iterator() {
			pointer = 0;
		}

		@Override
		public boolean hasNext() {
			Cell<T> current = getElement(pointer);

			if (current.next != null)
				return true;
			else
				return false;
		}

		@Override
		public Comparable next() {

			Cell<T> current = getElement(pointer);

			if (current == null) {
				System.out.println("No such element");
				return null;
			}

			pointer++;
			return current.content;

		}

	}

	private Cell<T> getElement(int pointer) {
		Cell<T> current = first;

		for (int i = 0; i < pointer; i++)
			current = current.next;

		return current;
	}

	@Override
	public void addSorted(Comparable element) {
		Cell<T> newCell = new Cell<>((T) element, null); // TODO: wtf warning
		Cell<T> last = first;

		if (last == null) {
			first = newCell;

		} else {
			while (last.next != null) {
				last = last.next;
			}
			last.next = newCell;
		}
	}

	@Override
	public SortedIterator iterator() {
		return new Iterator();
	}

	@Override
	public String toString() { // TODO: Remove
		String str = first.content.toString();

		Cell<T> current = first; // TODO: nice name

		while (current.next != null) {
			current = current.next;
			str += ", " + current.content.toString();
		}

		return str;
	}
}
