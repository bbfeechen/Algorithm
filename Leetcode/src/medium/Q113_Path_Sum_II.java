package medium;

import java.util.ArrayList;
import java.util.List;

public class Q113_Path_Sum_II {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		public TreeNode(int val) {
			this.val = val;
		}
	}
	
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> solution = new ArrayList<Integer>();
        pathSum(root, sum, solution, result);
        return result;
    }
    
    private void pathSum(TreeNode root, int sum, List<Integer> solution, List<List<Integer>> result) {
        if(root == null) {
            return;
        }
        sum -= root.val;
        if(sum == 0 && root.left == null && root.right == null) {
            solution.add(root.val);
            result.add(new ArrayList<Integer>(solution));
            solution.remove(solution.size() - 1);
            return;
        }
        solution.add(root.val);
        pathSum(root.left, sum, solution, result);
        pathSum(root.right, sum, solution, result);
        solution.remove(solution.size() - 1);
    }

	public static void main(String[] args) {

	}
}
