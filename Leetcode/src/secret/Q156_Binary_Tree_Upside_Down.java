package secret;

//Given a binary tree where all the right nodes are either leaf nodes with a sibling 
//(a left node that shares the same parent node) or empty, flip it upside down and turn 
//it into a tree where the original right nodes turned into left leaf nodes. Return the new root.
//
//For example:
//Given a binary tree {1,2,3,4,5},
//1
/// \
//2 3
/// \
//4 5
//
//return the root of the binary tree [4,5,2,#,#,3,1].
//4
/// \
//5 2
//  / \
// 3 1

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
