package medium;


public class Q222_Count_Complete_Tree_Nodes {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		public TreeNode(int val) {
			this.val = val;
		}
	}
	
	public static int countNodes(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int left = getLeftHeight(root);
        int right = getRightHeight(root);
        if(left == right) {
            return (2 << (left - 1)) - 1;
        } else {
            return countNodes(root.left) + countNodes(root.right) + 1;    
        }
    }
    
    private static int getLeftHeight(TreeNode root) {
        int height = 0;
        while(root != null) {
            height++;
            root = root.left;
        }
        return height;
    }
    
    private static int getRightHeight(TreeNode root) {
        int height = 0;
        while(root != null) {
            height++;
            root = root.right;
        }
        return height;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
