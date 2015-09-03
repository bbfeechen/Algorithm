package basic;

public class MyStack {
	private class ListNode {
		private int val;
		private ListNode next;
		
		private ListNode() {
			this.val = 0;
			this.next = null;
		} 
		
		private ListNode(ListNode node) {
			this.val = node.val;
			this.next = node.next;
		}
	}
	
	private int N;
	private ListNode first;
	
	public MyStack() {
		N = 0;
		first = null;
	}
	
	public boolean isEmpty() {
		return first == null;
	}
	
	public int size() {
		return N;
	}
	
	public void push(int val) {
		ListNode oldFirst = first;
		first = new ListNode();
		first.val = val;
		first.next = oldFirst;
		N++;
	}
	
	public int pop() {
		if(isEmpty()) {
			return -1;
		}
		int val = first.val;
		first = first.next;
		N--;
		return val;
	}
	
	public int peek() {
		if(isEmpty()) {
			return -1;
		}
		return first.val;
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
