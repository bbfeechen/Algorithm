package hard;
import java.util.Stack;


public class Q84_Largest_Rectangle_in_Histogram {
    public static int largestRectangleArea(int[] height) {
        if(height == null || height.length == 0) {
            return 0;
        }
        
        Stack<Integer> stack = new Stack<Integer>();
        int maxArea = 0;
        for(int i = 0; i <= height.length; i++) {
            int curr = (i == height.length) ? -1 : height[i];
            while(!stack.isEmpty() && curr <= height[stack.peek()]) {
                int h = height[stack.pop()];
                int w = stack.isEmpty() ? i : i - stack.peek() - 1;
                System.out.println(h + " x " + w + " = " + h * w);
                maxArea = Math.max(maxArea, h * w);
            }
            stack.push(i);
        }
        return maxArea;
    }
    
	public static void main(String[] args) {
		int[] height = {2,1,5,6,2,3};
		System.out.println(largestRectangleArea(height));
	}
}
