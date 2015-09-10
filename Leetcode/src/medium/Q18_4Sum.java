package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q18_4Sum {
	public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(nums == null || nums.length <= 3) {
            return result;
        }
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 3; i++) {
            if(i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for(int j = i + 1; j < nums.length - 2; j++) {
                if(j != i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int start = j + 1;
                int end = nums.length - 1;
                while(start < end) {
                    int sum = nums[i] + nums[j] + nums[start] + nums[end];
                    if(sum == target) {
                        List<Integer> solution = new ArrayList<Integer>();
                        solution.add(nums[i]);
                        solution.add(nums[j]);
                        solution.add(nums[start]);
                        solution.add(nums[end]);
                        result.add(solution);
                        start++;
                        end--;
                        while(start < end && nums[start] == nums[start - 1]) {
                            start++;
                        }
                        while(start < end && nums[end] == nums[end + 1]) {
                            end--;
                        }
                    } else if(sum < target) {
                        start++;
                    } else {
                        end--;
                    }
                }
            }
        }
        return result;
    }

	public static void main(String[] args) {
		int[] nums = {1, 0, -1, 0, -2, 2};
		List<List<Integer>> result = fourSum(nums, 0);
		for(List<Integer> solution : result) {
			for(int i : solution) {
				System.out.print(i + " ");
			}
			System.out.println();
		}
	}
}
