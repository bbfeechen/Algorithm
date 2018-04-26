package easy;

public class Q543_Diameter_of_Binary_Tree {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val) {
            this.val = val;
        }
    }

    private static int maxDepth = 0;

    public static int diameterOfBinaryTree(TreeNode root) {
        getDepth(root);
        return maxDepth;
    }

    private static int getDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = getDepth(root.left);
        int right = getDepth(root.right);
        maxDepth = Math.max(maxDepth, left + right);
        return Math.max(left, right) + 1;
    }

    public static void main(String[] args) {

    }
}
