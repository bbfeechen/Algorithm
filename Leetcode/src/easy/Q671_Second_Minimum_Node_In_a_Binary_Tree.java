package easy;

public class Q671_Second_Minimum_Node_In_a_Binary_Tree {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static int findSecondMinimumValue(TreeNode root) {
        int[] first = new int[] {root.val};
        int[] second = new int[] {Integer.MAX_VALUE};
        helper(root, first, second);

        return (second[0] == first[0] || second[0] == Integer.MAX_VALUE) ? -1 : second[0];
    }

    private static void helper(TreeNode root, int[] first, int[] second) {
        if (root == null) {
            return;
        }
        if (root.val != first[0] && root.val < second[0]) {
            second[0] = root.val;
        }
        helper(root.left, first, second);
        helper(root.right, first, second);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(7);

        System.out.println(findSecondMinimumValue(root));
    }
}
