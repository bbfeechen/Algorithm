package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q39_Combination_Sum {
	public static List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if(candidates == null) {
			return result;
		}
		Arrays.sort(candidates);
		dfs(candidates, target, 0, new ArrayList<Integer>(), result);
		return result;
	}
	
	private static void dfs(int[] candidates, int target, int index, 
			List<Integer> solution, List<List<Integer>> result) {
		if(target == 0) {
			result.add(new ArrayList<Integer>(solution));
			return;
		}
		if(target < 0 || index > candidates.length - 1) {
			return;
		}
		for(int i = index; i < candidates.length; i++) {
			solution.add(candidates[i]);
			dfs(candidates, target - candidates[i], i, solution, result);
			solution.remove(solution.size() - 1);
		}
	}

	public static void main(String[] args) {
		int[] candidates = {2,3,6,7};
		int target = 7;
		List<List<Integer>> result = combinationSum(candidates, target);
		for(List<Integer> solution : result) {
			for(int num : solution) {
				System.out.print(num + " ");
			}
			System.out.println();
		}
	}
}
