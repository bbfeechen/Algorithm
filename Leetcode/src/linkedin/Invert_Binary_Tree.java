package linkedin;

import java.util.LinkedList;
import java.util.Queue;

public class Invert_Binary_Tree {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		public TreeNode(int val) {
			this.val = val;
		}
	} 
	
	public static TreeNode invertTree(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		while(!queue.isEmpty()) {
			TreeNode node = queue.poll();
			TreeNode tmp = node.left;
			node.left = node.right;
			node.right = tmp;
			if(node.left != null) {
				queue.offer(node.left);
			}
			if(node.right != null) {
				queue.offer(node.right);
			}
		}
		return root;
	}
	
	private static void print(TreeNode root) {
		int level = getLevel(root);
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		int currLevel = 0;
		while(!queue.isEmpty() && currLevel < level) {
			int size = queue.size();
			for(int i = 0; i < size; i++) {
				TreeNode node = queue.poll();
				if(node != null) {
					System.out.print(node.val + " ");
					if(node.left != null) {
						queue.offer(node.left);
					} else {
						queue.offer(null);
					}
					if(node.right != null) {
						queue.offer(node.right);
					} else {
						queue.offer(null);
					}
				} else {
					System.out.print("#" + " ");
					queue.offer(null);
					queue.offer(null);
				}
			}
			System.out.println();
			currLevel++;
		}
	}
	
	private static int getLevel(TreeNode root) {
		if(root == null) {
			return 0;
		}
		return 1 + Math.max(getLevel(root.left), getLevel(root.right));
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(4);
		root.left = new TreeNode(2);
		root.right = new TreeNode(7);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(3);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(9);
//		print(root);
		
	}
}
