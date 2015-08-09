package easy;

import java.util.LinkedList;
import java.util.Queue;

public class Q225_Implement_Stack_using_Queues {
	public static class MyStack {
		private Queue<Integer> q1 = new LinkedList<Integer>();
		private Queue<Integer> q2 = new LinkedList<Integer>();
		
		public void push(int x) {
			q1.offer(x);
		}
		
		public void pop() {
			int size = q1.size();
			for(int i = 0; i < size - 1; i++) {
				q2.offer(q1.poll());
			}
			q1.poll();
			while(!q2.isEmpty()) {
				q1.offer(q2.poll());
			}
		}
		
		public int top() {
			int size = q1.size();
			for(int i = 0; i < size - 1; i++) {
				q2.offer(q1.poll());
			}
			int top = q1.peek();
			q2.offer(q1.poll());
			while(!q2.isEmpty()) {
				q1.offer(q2.poll());
			}
			return top;
		}
		
		public boolean empty() {
			return q1.isEmpty() && q2.isEmpty();
		}
	}

	public static void main(String[] args) {

	}
}