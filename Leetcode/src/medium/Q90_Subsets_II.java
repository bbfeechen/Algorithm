package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q90_Subsets_II {
	public static List<List<Integer>> subsetsWithDup(int[] nums) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(nums == null || nums.length == 0) {
            return result;
        }
        List<Integer> solution = new ArrayList<Integer>();
        Arrays.sort(nums);
        dfs(nums, 0, solution, result);
        return result;
	}
	
	private static void dfs(int[] nums, int index, List<Integer> solution, List<List<Integer>> result) {
        result.add(new ArrayList<Integer>(solution));
        for(int i = index; i < nums.length; i++) {
            if(i != index && nums[i] == nums[i - 1]) {
                continue;
            }
            solution.add(nums[i]);
            dfs(nums, i + 1, solution, result);
            solution.remove(solution.size() - 1);
        }
    }

	public static void main(String[] args) {
		int[] nums = {1, 2, 2};
		List<List<Integer>> result = subsetsWithDup(nums);
		for(List<Integer> list : result) {
			for(int i : list) {
				System.out.print(i);
			}
			System.out.println();
		}
	}
}
