import data.structure.BinarySearchTree;
import data.structure.BinarySearchTree.TreeNode;


public class Q4_1 {
	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree();
		bst.insert(50);
		bst.insert(25);
		bst.insert(75);
		bst.insert(12);
		bst.insert(37);
		bst.insert(60);
		bst.insert(87);
		System.out.println(isBalanced(bst.root));
	}
	
	private static boolean isBalanced(TreeNode root) {
		return checkHeight(root) == -1 ? false : true;
	}
	
	private static int checkHeight(TreeNode root) {
		if(root == null) {
			return 0;
		}
		int leftHeight = checkHeight(root.left);
		if(leftHeight == -1) {
			return -1;
		}
		
		int rightHeight = checkHeight(root.right);
		if(rightHeight == -1) {
			return -1;
		}
		
		int heightDiff = leftHeight - rightHeight;
		if(Math.abs(heightDiff) > 1) {
			return -1;
		} else {
			return Math.max(leftHeight, rightHeight) + 1;
		}
	}
}
