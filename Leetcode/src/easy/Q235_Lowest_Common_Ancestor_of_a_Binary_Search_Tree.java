package easy;

public class Q235_Lowest_Common_Ancestor_of_a_Binary_Search_Tree {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		public TreeNode(int val) {
			this.val = val;
		}
	}
	
	public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if(p.val > root.val && q.val > root.val) {
			return lowestCommonAncestor(root.right, p, q);
		}
		if(p.val < root.val && q.val < root.val) {
			return lowestCommonAncestor(root.left, p, q);
		}
		return root;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(6);
		root.left = new TreeNode(2);
		root.right = new TreeNode(8);
		root.left.left = new TreeNode(0);
		root.left.right = new TreeNode(4);
		root.left.right.left = new TreeNode(3);
		root.left.right.right = new TreeNode(5);
		
		root.right = new TreeNode(8);
		root.right.left = new TreeNode(7);
		root.right.right = new TreeNode(9);
		
		TreeNode lca = lowestCommonAncestor(root, new TreeNode(2), new TreeNode(8));
		System.out.println(lca.val);
	}
}
