package medium;

import java.util.ArrayList;
import java.util.List;

public class Q216_Combination_Sum_III {
	public static List<List<Integer>> combinationSum3(int k, int n) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
        dfs(k, n, 1, new ArrayList<Integer>(), result);
        return result;
	}
	
	private static void dfs(int k, int n, int index, List<Integer> solution, List<List<Integer>> result) {
		if(n == 0 && solution.size() == k) {
            result.add(new ArrayList<Integer>(solution));
            return;
        }
		for(int i = index; i <= 9; i++) {
			if(n < i) {
                break;
            }
            if(solution.size() > k) {
                break;
            }
			solution.add(i);
            dfs(k, n - i, i + 1, solution, result);
            solution.remove(solution.size() - 1);
		}
	}

	public static void main(String[] args) {
		List<List<Integer>> result = combinationSum3(3, 9);
		for(List<Integer> solution : result) {
			for(int num : solution) {
				System.out.print(num + " ");
			}
			System.out.println();
		}
	}
}
