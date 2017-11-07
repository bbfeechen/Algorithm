package easy;

import java.util.Stack;

public class Q682_Baseball_Game {

    public static int calPoints(String[] ops) {
        if (ops == null || ops.length == 0) {
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        int sum = 0;
        int lastVal = 0;
        int val = 0;
        for (String op : ops) {
            switch (op) {
                case "+":
                    int lastlastVal = stack.pop();
                    lastVal = stack.peek();
                    stack.push(lastlastVal);
                    val = lastlastVal + lastVal;
                    sum += val;
                    stack.push(val);
                    break;
                case "D":
                    lastVal = stack.peek();
                    val = lastVal * 2;
                    sum += val;
                    stack.push(val);
                    break;
                case "C":
                    val = stack.pop();
                    sum -= val;
                    break;
                default:
                    val = Integer.valueOf(op);
                    sum += val;
                    stack.push(val);
                    break;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(calPoints(new String[]{"5","2","C","D","+"}));
        System.out.println(calPoints(new String[]{"5","-2","4","C","D","9","+","+"}));
    }
}
