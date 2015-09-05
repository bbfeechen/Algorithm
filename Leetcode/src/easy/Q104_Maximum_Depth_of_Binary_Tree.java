package easy;


public class Q104_Maximum_Depth_of_Binary_Tree {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		public TreeNode(int val) {
			this.val = val;
		}
	}
	
	public static int maxDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        if(root.left == null) {
            return maxDepth(root.right) + 1;
        }
        if(root.right == null) {
            return maxDepth(root.left) + 1;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
