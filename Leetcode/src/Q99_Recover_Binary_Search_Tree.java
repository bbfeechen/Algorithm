

public class Q99_Recover_Binary_Search_Tree {
	public static class TreeNode {
		 int val;
		 TreeNode left;
		 TreeNode right;
		 TreeNode(int x) { val = x; }
	}	
	
    private static TreeNode first = null;
    private static TreeNode second = null;
    private static TreeNode prev = new TreeNode(Integer.MIN_VALUE);
    
    public static void recoverTree(TreeNode root) {
        traverse(root);
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }
    
    private static void traverse(TreeNode root) {
        if(root == null) {
            return;
        }
        
        traverse(root.left);
        if(first == null && root.val < prev.val) {
            first = prev;
        }
        
        if(first != null && root.val < prev.val) {
            second = root;
        }
        
        prev = root;
        traverse(root.right);
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
