package easy;

public class Q112_Path_Sum {
	public static class TreeNode {
		int val; 
		TreeNode left;
		TreeNode right;
		public TreeNode(int val) {
			this.val = val;
		}
	}
	
	private static int curr = 0;
    
    public static boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) {
            return false;
        }
        
        curr += root.val;
        
        if(root.left == null && root.right == null) {
            return sum == curr;
        }
        
        return hasPathSum(root.left, sum) || hasPathSum(root.right, sum);
    }
	
//	public static boolean hasPathSum(TreeNode root, int sum) {
//        if(root == null) {
//            return false;
//        }
//        if(root.left == null && root.right == null) {
//            return root.val == sum;
//        }
//        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
//    }

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.right = new TreeNode(2);
		 
		System.out.println(hasPathSum(root, 3));
	}
}
