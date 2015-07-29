package medium;

import java.util.ArrayList;
import java.util.List;

public class Q77_Combinations {
	public static List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		dfs(result, new ArrayList<Integer>(), 1, n, k);
		return result;
	}
	
	private static void dfs(List<List<Integer>> result, List<Integer> solution, int index, int n, int k) {
		if(solution.size() == k) {
			result.add(new ArrayList<Integer>(solution));
			return;
		}
		for(int i = index; i <= n; i++) {
			solution.add(i);
			dfs(result, solution, i + 1, n, k);
			solution.remove(solution.size() - 1);
		}
	}

	public static void main(String[] args) {
		List<List<Integer>> result = combine(4, 2);
		for(List<Integer> solution : result) {
			for(int num : solution) {
				System.out.print(num + " ");
			}
			System.out.println();
		}
	}
}
