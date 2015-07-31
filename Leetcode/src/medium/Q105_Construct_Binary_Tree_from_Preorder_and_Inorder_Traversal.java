package medium;


public class Q105_Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		public TreeNode(int val) {
			this.val = val;
		}
	}
	
	public static TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }
    
    private static TreeNode buildTree(int[] preorder, int prestart, int preend, int[] inorder, int instart, int inend) {
        if(prestart > preend || instart > inend) {
            return null;
        }
        int mid = findMiddle(inorder, instart, inend, preorder[prestart]);
        TreeNode root = new TreeNode(preorder[prestart]);
        root.left = buildTree(preorder, prestart + 1, prestart + mid - instart, inorder, instart, mid - 1);
        root.right = buildTree(preorder, prestart + mid - instart + 1, preend, inorder, mid + 1, inend);
        return root;
    }
    
    private static int findMiddle(int[] inorder, int instart, int inend, int target) {
        for(int i = instart; i <= inend; i++) {
            if(inorder[i] == target) {
                return i;
            }
        }
        return -1;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
