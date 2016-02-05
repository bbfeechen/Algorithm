package geeksforgeeks;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MirrorTree {
	static class TreeNode {
		int val;
		List<TreeNode> children;
		public TreeNode(int val) {
			this.val = val;
			this.children = new ArrayList<TreeNode>();
		}
	}
	
	public static void mirror(TreeNode root) {
		if(root == null) {
			return;
		}
		int N = root.children.size();
		if(N <= 1) {
			return;
		}
		for(int i = 0; i < N; i++) {
			mirror(root.children.get(i));
		}
		reverse(root.children);
	}
	
	private static void reverse(List<TreeNode> children) {
		for(int i = 0, j = children.size() - 1; i <= j; i++, j--) {
			TreeNode temp = children.get(i);
			children.set(i, children.get(j));
			children.set(j, temp);
		}
	}
	
	public static void print(TreeNode root) {
		if(root == null) {
			return;
		}
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		while(!queue.isEmpty()) {
			int size = queue.size();
			for(int i = 0; i < size; i++) {
				TreeNode node = queue.poll();
				if(node == null) {
					System.out.print("# ");
				} else {
					System.out.print(node.val + " ");
				}
				for(TreeNode child : node.children) {
					queue.offer(child);
				}
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(10);
		TreeNode node1 = new TreeNode(2);
		TreeNode node2 = new TreeNode(34);
		TreeNode node3 = new TreeNode(56);
		TreeNode node4 = new TreeNode(100);
		root.children.add(node1);
		root.children.add(node2);
		root.children.add(node3);
		root.children.add(node4);
		TreeNode node5 = new TreeNode(1);
		TreeNode node6 = new TreeNode(7);
		TreeNode node7 = new TreeNode(8);
		TreeNode node8 = new TreeNode(9);
		node2.children.add(node5);
		node4.children.add(node6);
		node4.children.add(node7);
		node4.children.add(node8);
		
		mirror(root);
		print(root);
	}
}
