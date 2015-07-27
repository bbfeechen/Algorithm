package hard;



public class Q124_Binary_Tree_Maximum_Path_Sum {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		public TreeNode(int val) {
			this.val = val;
		}
	}
	
	private static int max = Integer.MIN_VALUE;
    
    public static int maxPathSum(TreeNode root) {
        helper(root);
        return max;
    }
    
    private static int helper(TreeNode root) {
        if(root == null) {
            return 0;
        } 
        
        int left = helper(root.left);
        int right = helper(root.right);
        int single = Math.max(left, right) + root.val;
        single = Math.max(single, root.val);
        int arch = left + right + root.val;
        max = Math.max(max, Math.max(single, arch));
        return single;
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
		
		System.out.println(maxPathSum(root));
	}
}
