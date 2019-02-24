package easy;

import java.util.Stack;

public class Q716_Max_Stack {
    static class MaxStack {
        private Stack<Integer> stack;
        private Stack<Integer> maxStack;

        /** initialize your data structure here. */
        public MaxStack() {
            stack = new Stack<>();
            maxStack = new Stack<>();
        }

        public void push(int x) {
            if (maxStack.isEmpty() || maxStack.peek() <= x) {
                maxStack.push(x);
            }
            stack.push(x);
        }

        public int pop() {
            if (stack.isEmpty()) {
                return -1;
            }
            int x = stack.pop();
            if (!maxStack.isEmpty() && maxStack.peek() == x) {
                maxStack.pop();
            }
            return x;
        }

        public int top() {
            return stack.isEmpty() ? -1 : stack.peek();
        }

        public int peekMax() {
            return maxStack.isEmpty() ? -1 : maxStack.peek();
        }

        public int popMax() {
            if (maxStack.isEmpty()) {
                return -1;
            }
            int x = maxStack.pop();
            Stack<Integer> temp = new Stack<>();
            while (!stack.isEmpty() && stack.peek() != x) {
                temp.push(stack.pop());
            }
            stack.pop();
            while (!temp.isEmpty()) {
                push(temp.pop());
            }
            return x;
        }
    }

    public static void main(String[] args) {
        MaxStack stack = new MaxStack();
        stack.push(5);
        stack.push(1);
        System.out.println(stack.popMax());
        System.out.println(stack.peekMax());
    }
}
