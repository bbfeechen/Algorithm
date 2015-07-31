package medium;

public class Q11_Container_With_Most_Water {
	public static int maxArea(int[] height) {
        int start = 0;
        int end = height.length - 1;
        int result = 0;
        while(start < end) {
            int area = Math.min(height[end], height[start]) * (end - start);
            result = area > result ? area : result;
            if(height[start] < height[end]) {
                start++;
            } else {
                end--;
            }
        }
        return result;
    }

	public static void main(String[] args) {

	}
}
