import data.structure.BinarySearchTree;
import data.structure.BinarySearchTree.TreeNode;


public class Q4_5 {
	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree();
		bst.insert(50);
		bst.insert(25);
		bst.insert(75);
		bst.insert(12);
		bst.insert(37);
		bst.insert(60);
		bst.insert(51);
		bst.displayAll();
		System.out.println(checkBST(bst.root));
	}
	
	private static boolean checkBST(TreeNode root) {
		return checkBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	
	private static boolean checkBST(TreeNode root, int min, int max) {
		if(root == null) {
			return true;
		}
		
		if(root.data <= min || root.data >= max) {
			return false;
		}
		
		if(!checkBST(root.left, min, root.data) || !checkBST(root.right, root.data, max)) {
			return false;
		}
		return true;
	}
}
