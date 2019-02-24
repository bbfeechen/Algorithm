package hard;

import java.util.Stack;

public class Q224_Basic_Calculator {
    public static int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int sign = 1; // sign before parenthesis
        int result = 0; // result before parenthesis
        int number = 0;
        int i = 0;

        while (i < s.length()) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                number = number * 10 + c - '0';
            } else if (c == '+') {
                result += sign * number;
                number = 0;
                sign = 1;
            } else if (c == '-') {
                result += sign * number;
                number = 0;
                sign = -1;
            } else if (c == '(') {
                stack.push(result);
                stack.push(sign);
                sign = 1;
                result = 0;
            } else if (c == ')') {
                result += sign * number;
                number = 0;
                result *= stack.pop();
                result += stack.pop();
            }
            System.out.println("i = " + i + " sign = " + sign + " number = " + number + " result = " + result + " "
                    + "stack = " + stack);
            i++;
        }
        if (number != 0) {
            result += sign * number;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(calculate("(1+(4+5+2)-3)+(6+8)"));
    }
}
