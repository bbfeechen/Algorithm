package easy;

import java.util.HashSet;
import java.util.Set;

public class Q653_Two_Sum_IV_Input_is_a_BST {

    private static class TreeNode {
        private int val;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    public static boolean findTarget(TreeNode root, int k) {
        Set<Integer> set = new HashSet<>();
        return inOrder(root, set, k);
    }

    private static boolean inOrder(TreeNode root, Set<Integer> set, int k) {
        if (root == null) {
            return false;
        }
        if (set.contains(k - root.val)) {
            return true;
        }
        set.add(root.val);
        return inOrder(root.left, set, k) || inOrder(root.right, set, k);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(7);

        System.out.println(findTarget(root, 9));
        System.out.println(findTarget(root, 28));
    }
}
