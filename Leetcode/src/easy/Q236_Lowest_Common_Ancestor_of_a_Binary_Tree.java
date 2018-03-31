package easy;

import easy.Q235_Lowest_Common_Ancestor_of_a_Binary_Search_Tree.TreeNode;

public class Q236_Lowest_Common_Ancestor_of_a_Binary_Tree {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		public TreeNode(int val) {
			this.val = val;
		}
	}

	private static boolean hasP;
	private static boolean hasQ;

	public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		hasP = false;
		hasQ = false;
		TreeNode lca = findLCA(root, p, q);
		if (hasP && hasQ) {
			return lca;
		}
		return null;
	}

	private static TreeNode findLCA(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null) {
			return null;
		}
		if (root.val == p.val) {
			hasP = true;
			return root;
		}
		if (root.val == q.val) {
			hasQ = true;
			return root;
		}
		TreeNode left = findLCA(root.left, p, q);
		TreeNode right = findLCA(root.right, p, q);
		if (left != null && right != null) {
			return root;
		}
		return left != null ? left : right;
	}
	
//	public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//		if(root == null) {
//            return null;
//        }
//        if(root.equals(p) || root.equals(q)) {
//            return root;
//        }
//        TreeNode left = lowestCommonAncestor(root.left, p, q);
//        TreeNode right = lowestCommonAncestor(root.right, p, q);
//        if(left != null && right != null) {
//            return root;
//        }
//        return left != null ? left : right;
//	}

	public static void main(String[] args) {
//		TreeNode p = new TreeNode(5);
//		TreeNode q = new TreeNode(1);
//
//		TreeNode root = new TreeNode(3);
//		root.left = p;
//		root.right = q;
//		root.left.left = new TreeNode(6);
//		root.left.right = new TreeNode(2);
//		root.left.right.left = new TreeNode(7);
//		root.left.right.right = new TreeNode(4);
//
//		root.right = new TreeNode(1);
//		root.right.left = new TreeNode(0);
//		root.right.right = new TreeNode(8);

		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);

		TreeNode p = new TreeNode(1);
		TreeNode q = new TreeNode(2);
		
		TreeNode lca = lowestCommonAncestor(root, p, q);
		System.out.println(lca);
	}
}
