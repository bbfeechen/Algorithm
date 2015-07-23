package medium;

public class Q98_Validate_Binary_Search_Tree {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		public TreeNode(int val) {
			this.val = val;
		}
	}
	public static boolean isValidBST(TreeNode root) {
		return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
	}
	
	private static boolean isValidBST(TreeNode root, long min, long max) {
		if(root == null) {
			return true;
		}
		if(root.val > min && root.val < max) {
			return isValidBST(root.left, min, root.val) && isValidBST(root.right, root.val, max);
		}
		return false;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(15);
		root.left = new TreeNode(200);
		root.right = new TreeNode(20);
		System.out.println(isValidBST(root));
	}
}
