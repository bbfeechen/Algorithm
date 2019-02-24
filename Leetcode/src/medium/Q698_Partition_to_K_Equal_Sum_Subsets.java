package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q698_Partition_to_K_Equal_Sum_Subsets {
    public static boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % k != 0) {
            return false;
        }
        int target = sum / k;
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> solution = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        Arrays.sort(nums);
        dfs(nums, 0, target, visited, solution, res);
        return res.size() == k;
    }

    private static void dfs(int[] nums, int start, int target, boolean[] visited,
            List<Integer> solution, List<List<Integer>> res) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            if (solution.size() >= 1) {
                res.add(new ArrayList<>(solution));
                return;
            }
        }
        for (int i = start; i < nums.length; i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            solution.add(nums[i]);
            dfs(nums, i + 1, target - nums[i], visited, solution, res);
            solution.remove(solution.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 3, 5, 2, 1};
        System.out.println(canPartitionKSubsets(nums, 4));
    }
}
