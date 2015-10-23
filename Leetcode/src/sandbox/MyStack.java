package sandbox;


public class MyStack {
	public class ListNode {
		int val;
		ListNode next;
		public ListNode(int val) {
			this.val = val;
			this.next = null;
		}
	}
	
	private ListNode first;
	private int size;
	
	public MyStack() {
		size = 0;
		first = null;
	}
	
	public void push(int val) {
		ListNode oldFirst = first;
		first = new ListNode(val);
		first.next = oldFirst;
		size++;
	}
	
	public int pop() {
		if(isEmpty()) {
			return -1;
		}
		int val = first.val;
		first = first.next;
		size--;
		return val;
	}
	
	public int peek() {
		if(isEmpty()) {
			return -1;
		}
		return first.val;
	}
	
	public boolean isEmpty() {
		return first == null;
	}
	
	public int size() {
		return size;
	}

	public static void main(String[] args) {
		MyStack stack = new MyStack();
		stack.push(1);
		stack.push(2);
		System.out.println(stack.pop());
		stack.push(3);
		stack.push(4);
		while(!stack.isEmpty()) {
			System.out.print(stack.pop() + " ");
		}
	}
}
