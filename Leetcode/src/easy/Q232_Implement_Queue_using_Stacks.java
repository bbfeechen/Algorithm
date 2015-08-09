package easy;

import java.util.Stack;

public class Q232_Implement_Queue_using_Stacks {
	public static class MyQueue {
		private Stack<Integer> s1 = new Stack<Integer>();
		private Stack<Integer> s2 = new Stack<Integer>();
		
		public void push(int x) {
			s1.push(x);
		}
		
		public void pop() {
			if(s2.isEmpty()) {
				while(!s1.isEmpty()) {
					s2.push(s1.pop());
				}
			}
			s2.pop();
		}
		
		public int peek() {
			if(s2.isEmpty()) {
				while(!s1.isEmpty()) {
					s2.push(s1.pop());
				}
			}
			return s2.peek();
		}
		
		public boolean empty() {
			return s1.isEmpty() && s2.isEmpty();
		}
	}

	public static void main(String[] args) {
		
	}
}
