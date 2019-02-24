package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q377_Combination_Sum_IV {
    private static int line = 0;
    private static Map<Integer, List<Integer>> map = new HashMap<>();

    public static int combinationSum4(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> solution = new ArrayList<>();
        dfs(nums, target, 0, solution, result);
        return result.size();
    }

    private static void dfs(int[] nums, int target, int index, List<Integer> solution, List<List<Integer>> result) {
        line++;
        System.out.println("line = " + line + ".... target = " + target + ", index = "
                + index + ", solution = " + solution2str(solution) + ", " + "result = " + result2str(result));
        if (target == 0) {
            result.add(new ArrayList<>(solution));
            return;
        }
        if (target < 0) {
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            solution.add(nums[i]);
            dfs(nums, target - nums[i], i, solution, result);
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
        int[] candidates = {4, 2, 1};
        int target = 8;
        System.out.println(combinationSum4(candidates, target));
    }
}
