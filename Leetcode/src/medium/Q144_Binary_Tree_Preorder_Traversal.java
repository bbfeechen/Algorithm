package medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Q144_Binary_Tree_Preorder_Traversal {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		public TreeNode(int val) {
			this.val = val;
		}
	}
	
	public static List<Integer> preorderTraversalIteratively(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if(root == null) {
            return result;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        
        while(!stack.isEmpty()) {
            TreeNode node = stack.pop();
            result.add(node.val);
            if(node.right != null) {
                stack.push(node.right);
            }
            if(node.left != null) {
                stack.push(node.left);
            }
        }
        return result;
    }
	
	public static List<Integer> preorderTraversalRecursively(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if(root == null) {
            return result;
        }
        result.add(root.val);
        if(root.left != null) {
        	result.addAll(preorderTraversalRecursively(root.left));
        }
        if(root.right != null) {
        	result.addAll(preorderTraversalRecursively(root.right));
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
		
		List<Integer> result = preorderTraversalIteratively(root);
		for(int i : result) {
			System.out.print(i + " ");
		}
		System.out.println();
		result = preorderTraversalRecursively(root);
		for(int i : result) {
			System.out.print(i + " ");
		}
	}
}
