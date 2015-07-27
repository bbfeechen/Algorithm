package hard;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import easy.Q102_Binary_Tree_Level_Order_Traversal.TreeNode;


public class Q145_Binary_Tree_Postorder_Traversal {
	public static class TreeNode {
		 int val;
		 TreeNode left;
		 TreeNode right;
		 TreeNode(int x) { val = x; }
	}	
	
	public static List<Integer> postorderTraversalRecursively(TreeNode root) {
		List<Integer> result = new ArrayList<Integer>();
        if(root == null) {
            return result;
        }
        if(root.left != null) {
            result.addAll(postorderTraversalRecursively(root.left));
        }
        if(root.right != null) {
            result.addAll(postorderTraversalRecursively(root.right));
        }
        result.add(root.val);
        return result;
	}
	
	public static List<Integer> postorderTraversalIteratively(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if(root == null) {
            return result;
        }
        Stack<TreeNode> s1 = new Stack<TreeNode>();
        s1.push(root);
        Stack<TreeNode> s2 = new Stack<TreeNode>();
        while(!s1.isEmpty()) {
            TreeNode node = s1.pop();
            s2.push(node);
            if(node.left != null) {
                s1.push(node.left);
            }
            if(node.right != null) {
                s1.push(node.right);
            }
        }
        
        while(!s2.isEmpty()) {
            TreeNode node = s2.pop();
            result.add(node.val);
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
		
		List<Integer> result = postorderTraversalRecursively(root);
		for(int i : result) {
			System.out.print(i + " ");
		}
		System.out.println();
		
		result = postorderTraversalIteratively(root);
		for(int i : result) {
			System.out.print(i + " ");
		}
	}
}
