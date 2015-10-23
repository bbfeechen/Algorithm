package secret;


public class Q270_Closest_Binary_Search_Tree_Value {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		public TreeNode(int val) {
			this.val = val;
		}
	}
	
	public static int closestValue(TreeNode root, int target) {
		if(root == null) {
			return Integer.MIN_VALUE;
		}
		if(root.left == null && root.right == null) {
			return root.val;
		}
		int left = closestValue(root.left, target);
		int right = closestValue(root.right, target);
		int ld = Math.abs(left - target);
		int rd = Math.abs(right - target);
		int td = Math.abs(root.val - target);
		if(td < ld) {
			return td < rd ? root.val : right;
		} else {
			return ld < rd ? left : right;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
