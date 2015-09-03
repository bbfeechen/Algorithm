package interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ixl_learning_3 {
	public static List<List<Integer>> permuteUnique(int[] nums) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if(nums == null || nums.length == 0) {
			return result;
		}
		boolean[] visited = new boolean[nums.length];
		List<Integer> solution = new ArrayList<Integer>();
		Arrays.sort(nums);
		helper(result, solution, nums, visited);
		return result;
	}
	
	private static void helper(List<List<Integer>> result, List<Integer> solution, int[] nums, boolean[] visited) {
		if(solution.size() == nums.length) {
			result.add(new ArrayList<Integer>(solution));
			return;
		}
		
		for(int i = 0; i < nums.length; i++) {
			if((i != 0 && nums[i] == nums[i - 1] && !visited[i - 1]) || visited[i]) {
				continue;
			}
			visited[i] = true;
			solution.add(nums[i]);
			helper(result, solution, nums, visited);
			solution.remove(solution.size() - 1);
			visited[i] = false;
		}
	}

	public static void main(String[] args) {
		int[] nums = {1,1,2};
		List<List<Integer>> result = permuteUnique(nums);
		for(List<Integer> list : result) {
			System.out.print("[");
			for(int i : list) {
				System.out.print(i + "");
			}
			System.out.print("]");
		}
	}
}
