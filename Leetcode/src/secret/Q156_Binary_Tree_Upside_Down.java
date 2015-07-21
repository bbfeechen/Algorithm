package secret;

public class Q156_Binary_Tree_Upside_Down {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		public TreeNode(int val) {
			this.val = val;
		}
	}
	
	public static TreeNode UpsideDownBinaryTree(TreeNode root) {
		return udtree(root, null);
	}
	
	private static TreeNode udtree(TreeNode root, TreeNode parent) {
		if(root == null) {
			return parent;
		}
		TreeNode newRoot = udtree(root.left, parent);
		newRoot.left = parent.right;
		newRoot.right = parent;
		return newRoot;
	}

	public static void main(String[] args) {
		
	}
}
