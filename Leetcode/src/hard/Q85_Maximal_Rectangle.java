package hard;
import java.util.Stack;


public class Q85_Maximal_Rectangle {
    public static int maximalRectangle(char[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        
        int m = matrix.length;
        int n = matrix[0].length;
        int max = 0;
        int[] height = new int[n];
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(matrix[i][j] == '0') {
                    height[j] = 0;
                } else {
                    height[j] += 1;
                }
            }
            max = Math.max(max, largestRectangleArea(height));
        }
        return max;
    }
    
    private static int largestRectangleArea(int[] height) {
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
                maxArea = Math.max(maxArea, h * w);
            }
            stack.push(i);
        }
        return maxArea;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
