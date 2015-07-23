package easy;

import java.util.Stack;

public class Q20_Valid_Parentheses {
	public static boolean isValid(String s) {
		if(s == null || s.length() == 0) {
			return true;
		}
		Stack<Character> stack = new Stack<Character>();
		for(char c : s.toCharArray()) {
			if("([{".contains(c + "")) {
				stack.push(c);
			} else {
				if(!stack.isEmpty() && isPair(stack.peek(), c)) {
					stack.pop();
				} else {
					return false;
				}
			}
		}
		return true;
	}
	
	private static boolean isPair(char c1, char c2) {
		return (c1 == '(' && c2 == ')') ||
				(c1 == '[' && c2 == ']') ||
				(c1 == '{' && c2 == '}');
				
	}

	public static void main(String[] args) {
		String s = "()[]{}";
		System.out.println(isValid(s));
		s = "([)]";
		System.out.println(isValid(s));
	}
}
