package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q15_3Sum {
	public static List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if(nums == null || nums.length == 0) {
			return result;
		}
		Arrays.sort(nums);
		for(int i = 0; i < nums.length - 2; i++) {
			// mistake start
			if(i != 0 && nums[i] == nums[i - 1]) {
				continue;
			}
			// mistake end
			int start = i + 1;
			int end = nums.length - 1;
			while(start < end) {
				int sum = nums[i] + nums[start] + nums[end];
				if(sum == 0) {
					List<Integer> solution = new ArrayList<Integer>();
					solution.add(nums[i]);
					solution.add(nums[start]);
					solution.add(nums[end]);
					result.add(solution);
					start++;
					end--;
					// mistake start
					while(start < end && nums[start] == nums[start - 1]) {
						start++;
					}
					while(end > start && nums[end] == nums[end + 1]) {
						end--;
					} 
					// mistake end
				} else if(sum < 0) {
					start++;
				} else {
					end--;
				}
			}
		}
		return result;
	} 

	public static void main(String[] args) {
		int[] nums = {-1, 0, 1, 2, -1, -4};
		List<List<Integer>> result = threeSum(nums);
		for(List<Integer> solution : result) {
			for(int num : solution) {
				System.out.print(num + " ");
			}
			System.out.println();
		} 
	}
}
