package medium;


public class Q129_Sum_Root_to_Leaf_Numbers {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		public TreeNode(int val) {
			this.val = val;
		}
	}
	
	public static int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }
    
    private static int dfs(TreeNode root, int prev) {
        if(root == null) {
            return 0;
        }    
        int sum = prev * 10 + root.val;
        if(root.left == null && root.right == null) {
            return sum;
        }
        return dfs(root.left, sum) + dfs(root.right, sum);
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
