package medium;

import java.util.Stack;

import easy.Q110_Balanced_Binary_Tree.TreeNode;

public class Q173_Binary_Search_Tree_Iterator {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		public TreeNode(int val) {
			this.val = val;
		}
	}
	
	public static class BSTIterator {
		private Stack<TreeNode> stack = new Stack<TreeNode>();

	    public BSTIterator(TreeNode root) {
	        while(root != null) {
	            stack.push(root);
	            root = root.left;
	        }
	    }

	    /** @return whether we have a next smallest number */
	    public boolean hasNext() {
	        return !stack.isEmpty();
	    }

	    /** @return the next smallest number */
	    public int next() {
	        int result = 0;
	        TreeNode node = stack.pop();
	        result = node.val;
	        node = node.right;
	        while(node != null) {
	            stack.push(node);
	            node = node.left;
	        }
	        return result;
	    }
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(6);
		TreeNode p = root;
		p.left = new TreeNode(3);
		p = p.left;
		p.left = new TreeNode(1);
		
		TreeNode q = root;
		q.right = new TreeNode(9);
		q = q.right;
		q.left = new TreeNode(7);
		
		BSTIterator i = new BSTIterator(root);
		while (i.hasNext()) {
			System.out.print(i.next());
		}
	}
}
