package medium;

import java.util.Arrays;

public class Q16_3Sum_Closest {
	public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closest = nums[0] + nums[1] + nums[2];
        for(int i = 0; i < nums.length - 2; i++) {
            int start = i + 1;
            int end = nums.length - 1;
            while(start < end) {
                int sum = nums[i] + nums[start] + nums[end];
                if(sum == target) {
                    return sum;
                }
                if(sum < target) {
                    start++;
                } else {
                    end--;
                }
                closest = Math.abs(sum - target) < Math.abs(closest - target) ? sum : closest;
            }
        }
        return closest;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
