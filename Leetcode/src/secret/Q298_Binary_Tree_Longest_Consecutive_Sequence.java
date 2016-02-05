package secret;

public class Q298_Binary_Tree_Longest_Consecutive_Sequence {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		public TreeNode(int val) {
			this.val = val;
		}
	}
	
	public static int getLongestConsSeq(TreeNode root) {
		return helper(root, null, 0);
	}
	
	private static int helper(TreeNode curr, TreeNode parent, int len) {
		if(curr == null) {
			return len;
		}
		if(parent != null && curr.val == parent.val + 1) {
			len = len + 1;
		} else {
			len = 1;
		}
		return Math.max(len, Math.max(helper(curr.left, curr, len), helper(curr.right, curr, len)));
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.right = new TreeNode(3);
		root.right.left = new TreeNode(2);
		root.right.right = new TreeNode(4);
		root.right.right.right = new TreeNode(5);
		System.out.println(getLongestConsSeq(root));
	}
}
