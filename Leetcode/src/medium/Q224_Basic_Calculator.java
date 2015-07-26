package medium;

import java.util.Stack;

public class Q224_Basic_Calculator {
	public static int calculate(String s) {
		Stack<Integer> stack = new Stack<Integer>();
		int res = 0;
		int sign = 1;
		for(int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if(Character.isDigit(c)) {
				int num = c - '0';
				while(i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))) {
					i++;
					num = num * 10 + s.charAt(i) - '0';
				}
				res += sign * num;
			} else if(c == '+') {
				sign = 1;
			} else if(c == '-') {
				sign = -1;
			} else if(c == '(') {
				stack.push(res);
				stack.push(sign);
				res = 0;
				sign = 1;
			} else if(c == ')') {
				res = stack.pop() * res + stack.pop();
				sign = 1;
			}
		}
		return res;
	}

	public static void main(String[] args) {
		String s = "(1+(4+5+2)-3)+(6+8)";
		System.out.println(calculate(s));
	}
}
