package easy;

import java.util.Stack;

public class Q155_Min_Stack {
	private static Stack<Integer> s1 = new Stack<Integer>();
    private static Stack<Integer> s2 = new Stack<Integer>();
    
    public static void push(int x) {
        if(s2.isEmpty() || x <= s2.peek()) {
            s2.push(x);
        }
        s1.push(x);
    }

    public static void pop() {
        if(s1.peek().equals(s2.peek())) {
            s2.pop();
        }
        s1.pop();
    }

    public static int top() {
        return s1.peek();
    }

    public static int getMin() {
        return s2.peek();
    }

	public static void main(String[] args) {
		
	}
}
