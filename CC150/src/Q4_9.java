import data.structure.BinarySearchTree;
import data.structure.BinarySearchTree.TreeNode;


public class Q4_9 {
	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree();
		bst.insert(50);
		bst.insert(25);
		bst.insert(75);
		bst.insert(10);
		bst.insert(37);
		bst.insert(60);
		bst.insert(80);
		bst.insert(5);
		bst.insert(15);
		bst.insert(30);
		bst.insert(42);
		bst.insert(55);
		bst.insert(63);
		bst.insert(78);
		bst.insert(83);
		bst.displayAll();
		
		findSum(bst.root, 90);
	}
	
	private static void findSum(TreeNode node, int sum) {
		int depth = depth(node);
		int[] path = new int[depth];
		findSum(node, sum, path, 0);
	}
	
	private static int depth(TreeNode node) {
	    if(node == null) {
	    	return 0;
	    } else {
	    	return 1 + Math.max(depth(node.left), depth(node.right));
	    }
	}
	
	private static void findSum(TreeNode node, int sum, int[] path, int level) {
		if(node == null) {
			return;
		}
		path[level] = node.data;
		int t = 0;
		for(int i = level; i >= 0; i--) {
			t += path[i];
			if(t == sum) {
				print(path, i, level);
			}
		}
		
		findSum(node.left, sum, path, level + 1);
		findSum(node.right, sum, path, level + 1);
		path[level] = Integer.MIN_VALUE;
	}
	
	private static void print(int[] path, int start, int end) {
		for(int i = start; i <= end; i++) {
			System.out.print(path[i] + " ");
		}
		System.out.println();
	}
}
