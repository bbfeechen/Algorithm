package linkedin;


public class Count_Univalue_Subtrees {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		public TreeNode(int val) {
			this.val = val;
		}
	}
	
	private int count = 0;
    public int countUnivalSubtrees(TreeNode root) {
        if (root == null) {
            return 0;
        }
         
        countUnivalSubtreesHelper(root);
        return count;
    }
     
    private int countUnivalSubtreesHelper(TreeNode root) {
        if (root == null) {
            return Integer.MAX_VALUE;
        }
         
        // Divide
        int left = countUnivalSubtreesHelper(root.left);
        int right = countUnivalSubtreesHelper(root.right);
         
        // left and right are all empty
        if (left == Integer.MAX_VALUE && right == Integer.MAX_VALUE) {
            count++;
            return root.val;
        } else if (left == Integer.MAX_VALUE || right == Integer.MAX_VALUE) {
            if (root.val == left || root.val == right) {
                count++;
                return root.val;
            } else {
                return Integer.MIN_VALUE;
            }
        } else {
            if (root.val == left && root.val == right) {
                count++;
                return root.val;
            } else {
                return Integer.MIN_VALUE;
            }
        }
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
