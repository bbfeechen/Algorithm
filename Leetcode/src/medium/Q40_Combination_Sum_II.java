package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q40_Combination_Sum_II {
	private static int line = 0;

	public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
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
		line++;
		System.out.println("line = " + line + ".... target = " + target + ", index = "
				+ index + ", solution = " + solution2str(solution) + ", " + "result = " + result2str(result));

		if(target == 0) {
			result.add(new ArrayList<Integer>(solution));
			return;
		}
		if(target < 0 || index > candidates.length - 1) {
            return;
        }
		for(int i = index; i < candidates.length; i++) {
			if(i > index && candidates[i - 1] == candidates[i]) {
				continue;
			}
			solution.add(candidates[i]);
			dfs(candidates, target - candidates[i], i + 1, solution, result);
			solution.remove(solution.size() - 1);
		}
	}

	private static String solution2str(List<Integer> solution) {
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		for(int i = 0; i < solution.size(); i++) {
			sb.append(solution.get(i));
			if (i != solution.size() - 1) {
				sb.append(" ");
			}
		}
		sb.append("]");
		return sb.toString();
	}

	private static String result2str(List<List<Integer>> result) {
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		for(List<Integer> solution : result) {
			sb.append("[");
			sb.append(solution2str(solution));
			sb.append("]");
		}
		sb.append("]");
		return sb.toString();
	}

	public static void main(String[] args) {
		int[] candidates = {10,1,2,7,6,1,5};
		int target = 8;
		List<List<Integer>> result = combinationSum2(candidates, target);
		System.out.println(result2str(result));
	}
}
