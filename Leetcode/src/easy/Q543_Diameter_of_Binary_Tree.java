package easy;

public class Q543_Diameter_of_Binary_Tree {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val) {
            this.val = val;
        }
    }
    static class MaxDiameter {
        int val;
        public MaxDiameter(int val) {
            this.val = val;
        }
    }
    public static int diameterOfBinaryTree(TreeNode root) {
        MaxDiameter maxDiameter = new MaxDiameter(0);
        dfs(root, maxDiameter);
        return maxDiameter.val;
    }

    private static int dfs(TreeNode root, MaxDiameter maxDiameter) {
        if (root == null) {
            return 0;
        }
        int leftHeight = dfs(root.left, maxDiameter);
        int rightHeight = dfs(root.right, maxDiameter);
        maxDiameter.val = Math.max(leftHeight + rightHeight, maxDiameter.val);
        return Math.max(leftHeight, rightHeight) + 1;
    }

    public static void main(String[] args) {

    }
}
