package basic;

public class MyQueue {
	private class ListNode {
		private int val;
		private ListNode next;
		public ListNode() {
			this.val = 0;
			this.next = null;
		}
		public ListNode(ListNode node) {
			this.val = node.val;
			this.next = node.next;
		}
	}
	
	private int N;
	private ListNode first;
	private ListNode last;
	
	public MyQueue() {
		N = 0;
		first = null;
		last = null;
	}
	
	public boolean isEmpty() {
		return first == null;
	}
	
	public int size() {
		return N;
	}
	
	public void enqueue(int val) {
		ListNode oldFirst = last;
		last = new ListNode();
		last.val = val;
		last.next = null;
		if(isEmpty()) {
			first = last;
		} else {
			oldFirst.next = last; 
		}
		N++;
	}
	
	public int dequeue() {
		if(isEmpty()) {
			return -1;
		}
		int val = first.val;
		first = first.next;
		N--;
		if(isEmpty()) {
			last = null;
		}
		return val;
	}

	public static void main(String[] args) {
		MyQueue queue = new MyQueue();
		queue.enqueue(1);
		queue.enqueue(2);
		System.out.println(queue.dequeue());
		queue.enqueue(3);
		queue.enqueue(4);
		while(!queue.isEmpty()) {
			System.out.print(queue.dequeue() + " ");
		}
	}
}
