import java.util.Iterator;

public class Bag<Item> implements Iterable<Item> {
	private Node first;
	private class Node {
		Item item;
		Node next;
	}
	
	private int N;
	public boolean isEmpty() { return first == null; }
	public int size() { return N; }
	
	public void add(Item item) {
		Node oldfirst = first;
		first = new Node();
		first.item = item;
		first.next = oldfirst;
		N++;
	}
	
	public Iterator<Item> iterator() { return new ListIterator(); }
	private class ListIterator implements Iterator<Item> {
		private Node current = first;
		public boolean hasNext() { return current != null; }
		public void remove() {}
		public Item next() {
			Item item = current.item;
			current = current.next;
			return item;
		}
	}
	
	public static void main(String[] args) {
		Bag<String> b = new Bag<String>();
		while(!StdIn.isEmpty()) {
			String item = StdIn.readString();
			if(!item.equals("-")) {
				b.add(item);
			} else if(!b.isEmpty()) {
				StdOut.println("size of the queue is " + b.size());
			}
		}
		StdOut.println("size of the queue is " + b.size());
	}
}