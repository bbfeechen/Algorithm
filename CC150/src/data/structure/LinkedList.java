package data.structure;


import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedList<Item> implements Iterable<Item> {
	private int N;
	private Node first;
	
	private class Node {
		private Item item;
		private Node next;
	}
	
	public LinkedList() {
		N = 0;
		first = null;
	}
	
	public boolean isEmpty() {
		return first == null;
    }

    public int size() {
    	return N;
    }

    public void add(Item item) {
    	Node oldfirst = first;
    	first = new Node();
    	first.item = item;
    	first.next = oldfirst;
    	N++;
    }
	
	@Override
	public Iterator<Item> iterator() {
		return new ListIterator();
	}
	
	private class ListIterator implements Iterator<Item> {
		private Node current = first;
		
		public boolean hasNext() { return current != null; }
		public void remove() { throw new UnsupportedOperationException(); }
		public Item next() {
			if(!hasNext()) { throw new NoSuchElementException(); }
			Item item = current.item;
			current = current.next;
			return item;
		}
	}
	
	public static void test(String[] args) {
		LinkedList<Integer> linkedList = new LinkedList<Integer>();
		linkedList.add(1);
//		StdOut.print(linkedList.size());
	}
}
