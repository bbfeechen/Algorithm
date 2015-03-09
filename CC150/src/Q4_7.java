import data.structure.BinarySearchTree;
import data.structure.BinarySearchTree.TreeNode;


public class Q4_7 {
	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree();
		bst.insert(50);
		bst.insert(25);
		bst.insert(75);
		bst.insert(12);
		bst.insert(37);
		bst.insert(60);
		bst.insert(80);
		bst.displayAll();
		
		TreeNode node = commonAncestor(bst.root, bst.find(60), bst.find(80));
		System.out.println(node.data);
	}
	
	private static TreeNode commonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if(!covers(root, p) || !covers(root, q)) {
			return null;
		}
		return commonAncestorHelper(root, p, q);
	}
	
	private static TreeNode commonAncestorHelper(TreeNode root, TreeNode p, TreeNode q) {
		if(root == null) {
			return null;
		}
		
		if(root == p || root == q) {
			return root;
		}
		
		boolean isPOnLeft = covers(root.left, p);
		boolean isQOnLeft = covers(root.left, q);
		
		if(isPOnLeft != isQOnLeft) {
			return root;
		}
		
		TreeNode childSide = isPOnLeft ? root.left : root.right;
		
		return commonAncestorHelper(childSide, p, q);
	}
	
	private static boolean covers(TreeNode root, TreeNode p) {
		if(root == null) {
			return false;
		}
		
		if(root == p) {
			return true;
		}
		
		return covers(root.left, p) || covers(root.right, p);
	}
}
