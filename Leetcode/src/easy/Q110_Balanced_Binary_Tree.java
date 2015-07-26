package easy;

public class Q110_Balanced_Binary_Tree {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		public TreeNode(int val) {
			this.val = val;
		}
	}
	
	public static boolean isBalanced(TreeNode root) {
		if(root == null) {
			return true;
		}
		int left = getHeight(root.left);
		int right = getHeight(root.right);
		if(Math.abs(left - right) > 1) {
			return false;
		}
		return isBalanced(root.left) && isBalanced(root.right);
	}
	
	private static int getHeight(TreeNode root) {
		if(root == null) {
			return 0;
		}
		int left = getHeight(root.left);
		int right = getHeight(root.right);
		return Math.max(left, right) + 1;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		TreeNode p = root;
		p.left = new TreeNode(2);
		p = p.left;
		p.left = new TreeNode(1);
		
		TreeNode q = root;
		q.right = new TreeNode(5);
		q = q.right;
		q.left = new TreeNode(4);
		System.out.println(isBalanced(root));
		
		p = p.left;
		p.left = new TreeNode(-1);
		p = p.left;
		p.left = new TreeNode(-2);
		System.out.println(isBalanced(root));
	}
}
