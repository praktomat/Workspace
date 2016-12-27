package edu.kit.informatik;

public class Main {
	public static void main(String[] args) {
		LinkedSortedAppendList<Integer> list = new LinkedSortedAppendList<Integer>();
		
		list.addSorted(3);
		list.addSorted(2);
		list.addSorted(2);
		
		SortedIterator iterator = list.iterator();
		
		System.out.println(iterator.next());
		System.out.println(iterator.next());
		System.out.println(iterator.next());
		System.out.println(iterator.next());
	}
}

// TODO: Check how to write javadoc for interfaces and inner classes
