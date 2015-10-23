package sandbox;


public class MyQueue {
	public class ListNode {
		int val;
		ListNode next;
		public ListNode(int val) {
			this.val = val;
			this.next = null;
		}
	}
	
	private ListNode first;
	private ListNode last;
	private int size;
	
	public MyQueue() {
		first = null;
		last = null;
		size = 0;
	}
	
	public void enqueue(int val) {
		ListNode oldLast = last;
		last = new ListNode(val);
		if(isEmpty()) {
			first = last;
		} else {
			oldLast.next = last;
		}
		size++;
	}
	
	public int dequeue() {
		if(isEmpty()) {
			return -1;
		}
		int val = first.val;
		first = first.next;
		size--;
		if(isEmpty()) {
			last = null;
		}
		return val;
	}
	
	public boolean isEmpty() {
		return first == null;
	}
	
	public int size() {
		return size;
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
