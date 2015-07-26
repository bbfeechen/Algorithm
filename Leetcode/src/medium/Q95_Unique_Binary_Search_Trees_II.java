package medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Q95_Unique_Binary_Search_Trees_II {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		public TreeNode(int val) {
			this.val = val;
		}
	}
	
	public static List<TreeNode> generateTrees(int n) {
		return generateTrees(1, n);
	}
	
	private static List<TreeNode> generateTrees(int start, int end) {
		List<TreeNode> result = new ArrayList<TreeNode>();
		if(start > end) {
			result.add(null);
			return result;
		}
		for(int i = start; i <= end; i++) {
			List<TreeNode> left = generateTrees(start, i - 1);
			List<TreeNode> right = generateTrees(i + 1, end);
			for(TreeNode l : left) {
				for(TreeNode r : right) {
					TreeNode root = new TreeNode(i);
					root.left = l;
					root.right = r;
					result.add(root);
				}
			}
		}
		return result;
	}
	
	private static void printBST(TreeNode root, int level) {
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		int currLevel = 1;
		while(!queue.isEmpty()) {
			if(currLevel > level) {
				return;
			}
			int size = queue.size();
			for(int i = 0; i < size; i++) {
				TreeNode node = queue.poll();
				if(node != null) {
					System.out.print(node.val);
					queue.offer(node.left);
					queue.offer(node.right);
				} else {
					System.out.print("#");
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
		return Math.max(getLevel(root.left), getLevel(root.right)) + 1;
	}

	public static void main(String[] args) {
		List<TreeNode> result = generateTrees(3);
		for(TreeNode root : result) {
			int level = getLevel(root);
			printBST(root, level);
			System.out.println();
		}
	}
}
