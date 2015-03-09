import data.structure.BinarySearchTree;
import data.structure.BinarySearchTree.TreeNode;


public class Q4_3 {
	public static void main(String[] args) {
		int[] array = new int[] {12, 25, 37, 50, 60, 75, 87};
		TreeNode root = createMinimalBST(array);
		BinarySearchTree bst = new BinarySearchTree(root);
		bst.displayAll();
	}
	
	private static TreeNode createMinimalBST(int[] array) {
		return createMinimalBST(array, 0, array.length - 1);
	}
	
	private static TreeNode createMinimalBST(int[] array, int start, int end) {
		if(end < start) {
			return null;
		}
		
		int mid = (start + end) / 2;
		BinarySearchTree bst = new BinarySearchTree();
		TreeNode node = bst.new TreeNode(array[mid]);
		node.left = createMinimalBST(array, start, mid - 1);
		node.right = createMinimalBST(array, mid + 1, end);
		return node;
	}
}
