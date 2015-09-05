package easy;

import easy.Q102_Binary_Tree_Level_Order_Traversal.TreeNode;

public class Q101_Symmetric_Tree {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		public TreeNode(int val) {
			this.val = val;
		}
	}
	
	public static boolean isSymmetric(TreeNode root) {
        if(root == null) {
            return true;
        }
        
        return isSymmetric(root.left, root.right);
    }
     
    private static boolean isSymmetric(TreeNode left, TreeNode right) {
        if(left == null) {
            return right == null;
        }
        if(right == null) {
            return left == null;
        }
        if(left.val == right.val) {
            return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
        }
        
        return false;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
