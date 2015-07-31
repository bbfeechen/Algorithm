package medium;

public class Q106_Construct_Binary_Tree_from_Inorder_and_Postorder_Traversal {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		public TreeNode(int val) {
			this.val = val;
		}
	}
	
	public static TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTree(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }
    
    private static TreeNode buildTree(int[] inorder, int instart, int inend, int[] postorder, int poststart, int postend) {
        if(instart > inend || poststart > postend) {
            return null;
        }
        int mid = findMiddle(inorder, instart, inend, postorder[postend]);
        TreeNode root = new TreeNode(inorder[mid]);
        root.left = buildTree(inorder, instart, mid - 1, postorder, poststart, poststart + mid - instart - 1);
        root.right = buildTree(inorder, mid + 1, inend, postorder, poststart + mid - instart, postend - 1);
        return root;
    }
    
    private static int findMiddle(int[] inorder, int start, int end, int target) {
        for(int i = start; i <= end; i++) {
            if(inorder[i] == target) {
                return i;
            }
        }
        return -1;
    }

	public static void main(String[] args) {

	}
}
