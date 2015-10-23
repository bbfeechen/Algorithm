package linkedin;

public class Same_Tree {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		public TreeNode(int val) {
			this.val = val;
		}
	}
	
	public static boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null) {
            return q == null;
        }
        if(q == null) {
            return p == null;
        }
        if(p.val != q.val) {
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
