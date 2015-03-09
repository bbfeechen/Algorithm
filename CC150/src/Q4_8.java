import data.structure.BinarySearchTree;
import data.structure.BinarySearchTree.TreeNode;


public class Q4_8 {
	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree();
		bst.insert(50);
		bst.insert(25);
		bst.insert(75);
		bst.insert(12);
		bst.insert(37);
		bst.insert(60);
		bst.insert(80);
		bst.insert(3);
		bst.insert(13);
		bst.insert(30);
		bst.insert(42);
		bst.insert(55);
		bst.insert(63);
		bst.insert(78);
		bst.insert(83);
		bst.displayAll();
		
		System.out.println(containsTree(bst.find(25), bst.find(12)));
	}

	private static boolean containsTree(TreeNode t1, TreeNode t2) {
		if(t2 == null) {
			return true;
		}
		return subTree(t1, t2);
	}
	
	private static boolean subTree(TreeNode t1, TreeNode t2) {
		if(t1 == null) {
		    return false;
		}
		if(t1.data == t2.data) {
		    if(matchTree(t1, t2)) {
		    	return true;
		    }
		}
		return subTree(t1.left, t2) || subTree(t1.right, t2);
	}
	
	private static boolean matchTree(TreeNode t1, TreeNode t2) {
		if(t1 == null && t2 == null) {
			return true;
		}
		
		if(t1 == null || t2 == null) {
			return false;
		}
		
		if(t1.data != t2.data) {
			return false;
		} 
		
		return matchTree(t1.left, t2.left) && matchTree(t1.right, t2.right);
	}
}
