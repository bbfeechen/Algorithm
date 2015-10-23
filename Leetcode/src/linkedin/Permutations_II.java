package linkedin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations_II {
	public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(nums == null || nums.length == 0) {
            return result;
        }
        List<Integer> solution = new ArrayList<Integer>();
        Arrays.sort(nums);
        boolean[] visited = new boolean[nums.length];
        dfs(result, solution, nums, visited);
        return result;
    }
    
    private static void dfs(List<List<Integer>> result, List<Integer> solution, int[] nums, boolean[] visited) {
        if(solution.size() == nums.length) {
            result.add(new ArrayList<Integer>(solution));
            return;
        }
        
        for(int i = 0; i < nums.length; i++) {
            if(visited[i] || (i != 0 && nums[i] == nums[i - 1] && !visited[i - 1])) {
                continue;
            }
            visited[i] = true;
            solution.add(nums[i]);
            dfs(result, solution, nums, visited);
            solution.remove(solution.size() - 1);
            visited[i] = false;
        }
    }

	public static void main(String[] args) {
		int[] num = {1,1,2};
		List<List<Integer>> result = permuteUnique(num);
		for(List<Integer> list : result) {
			System.out.print("[");
			for(int i : list) {
				System.out.print(i + "");
			}
			System.out.print("]");
		}
	}
}
