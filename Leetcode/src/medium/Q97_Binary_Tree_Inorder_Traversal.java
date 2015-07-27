package medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Q97_Binary_Tree_Inorder_Traversal {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		public TreeNode(int val) {
			this.val = val;
		}
	}
	
	public static List<Integer> inorderTraversalIteratively(TreeNode root) {
		List<Integer> result = new ArrayList<Integer>();
		if(root == null) {
			return result;
		}
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode pNode = root;
		while(!stack.isEmpty() || pNode != null) {
			if(pNode != null) {
				stack.push(pNode);
				pNode = pNode.left;
			} else {
				TreeNode node = stack.pop();
				result.add(node.val);
				pNode = node.right;
			}
		}
		return result;
	}
	
	public static List<Integer> inorderTraversalRecursively(TreeNode root) {
		List<Integer> result = new ArrayList<Integer>();
		if(root == null) {
			return result;
		}
		if(root.left != null) {
			result.addAll(inorderTraversalRecursively(root.left));
		}
		result.add(root.val);
		if(root.right != null) {
			result.addAll(inorderTraversalRecursively(root.right));
		}
		return result;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(6);
		TreeNode p = root;
		p.left = new TreeNode(3);
		p = p.left;
		p.left = new TreeNode(1);
		p.right = new TreeNode(4);
		
		TreeNode q = root;
		q.right = new TreeNode(9);
		q = q.right;
		q.left = new TreeNode(7);
		q.right = new TreeNode(10);
		
		List<Integer> result = inorderTraversalIteratively(root);
		for(int i : result) {
			System.out.print(i + " ");
		}
		System.out.println();
		result = inorderTraversalRecursively(root);
		for(int i : result) {
			System.out.print(i + " ");
		}
	}
}
