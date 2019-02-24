package medium;

import java.util.Stack;

public class Q84_Largest_Rectangle_in_Histogram {

    public static int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }
        int res = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i <= heights.length; i++) {
            int currHeight = i == heights.length ? 0 : heights[i];
            while (!stack.isEmpty() && currHeight < heights[stack.peek()]) {
                int top = stack.pop();
                int h = heights[top];
                int w = i - top;
                res = Math.max(res, h * w);
            }
            stack.push(i);
        }
        return res;
    }


    public static void main(String[] args) {
        System.out.println(largestRectangleArea(new int[] {1, 1}));
    }
}
