import data.structure.SingleLinkedList;
import data.structure.Stack;


public class Q3_2 {
	public static void main(String[] args) {
		StackWithMin stack = new StackWithMin();  
		stack.push(3);
		stack.push(1);
		stack.push(8);
		stack.push(7);
		stack.push(6);
		System.out.println(stack.pop());
		System.out.println(stack.min());
	}
    
	public static class StackWithMin extends Stack<Integer> {
		Stack<Integer> s2;
		
		public StackWithMin() {
			s2 = new Stack<Integer>();
		}
		
		public void push(int value) {
			if(value <= min()) {
				s2.push(value);
			}
			super.push(value);
		}
		
		public Integer pop() {
			int value = super.pop();
			if(value == min()) {
				s2.pop();
			}
			return value;
		}
		
		public int min() {
			if(s2.isEmpty()) {
				return Integer.MAX_VALUE;
			} else {
				return s2.peek();
			}
		}
	}
}
