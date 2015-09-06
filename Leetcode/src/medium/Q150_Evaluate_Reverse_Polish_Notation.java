package medium;

import java.util.Stack;

public class Q150_Evaluate_Reverse_Polish_Notation {
	public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<Integer>();
        for(String token : tokens) {
            if("+-*/".contains(token)) {
                int op2 = stack.pop();
                int op1 = stack.pop();
                int result = 0;
                switch(token) {
                    case "+":
                        result = op1 + op2;
                        break;
                    case "-":
                        result = op1 - op2;
                        break;
                    case "*":
                        result = op1 * op2;
                        break;
                    case "/":
                        result = op1 / op2;
                        break;
                    default:
                        break;
                }
                stack.push(result);
            } else {
                stack.push(Integer.valueOf(token));
            }
        }
        return stack.pop();
    }

	public static void main(String[] args) {
		String[] tokens = {"2", "1", "+", "3", "*"};
		System.out.println(evalRPN(tokens));
	}
}
