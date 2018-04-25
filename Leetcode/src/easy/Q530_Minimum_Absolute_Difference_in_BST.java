package easy;

import java.util.TreeSet;

public class Q530_Minimum_Absolute_Difference_in_BST {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    // private static int prev = Integer.MAX_VALUE;
    private static int minDiff = Integer.MAX_VALUE;
    private static TreeSet<Integer> set = new TreeSet<>();

    public static int getMinimumDifference(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if (!set.isEmpty()) {
            if (set.floor(root.val) != null) {
                minDiff = Math.min(minDiff, Math.abs(root.val - set.floor(root.val)));
            }
            if (set.ceiling(root.val) != null) {
                minDiff = Math.min(minDiff, Math.abs(root.val - set.ceiling(root.val)));
            }
        }
        set.add(root.val);
        getMinimumDifference(root.left);
        getMinimumDifference(root.right);

        // inOrder(root);
        return minDiff;
    }

    // private static void inOrder(TreeNode root) {
    //     if (root == null) {
    //         return;
    //     }
    //     inOrder(root.left);
    //     minDiff = Math.min(minDiff, Math.abs(root.val - prev));
    //     prev = root.val;
    //     inOrder(root.right);
    // }

    public static void main(String[] args) {

    }
}
