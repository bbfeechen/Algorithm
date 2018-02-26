package medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Q117_Populating_Next_Right_Pointers_in_Each_Node_II {
    static class TreeLinkNode {
        int val;
        TreeLinkNode left, right, next;
        TreeLinkNode(int x) { val = x; }
    }

    public static void connect(TreeLinkNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeLinkNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<TreeLinkNode> level = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeLinkNode curr = queue.poll();
                level.add(curr);
                if (curr.left != null) {
                    queue.add(curr.left);
                }
                if (curr.right != null) {
                    queue.add(curr.right);
                }
            }
            for (int i = 0; i < level.size(); i++) {
                if (i == level.size() - 1) {
                    level.get(i).next = null;
                } else {
                    level.get(i).next = level.get(i + 1);
                }
            }
        }
    }

    public static void main(String[] args) {
        TreeLinkNode root = new TreeLinkNode(1);
        root.left = new TreeLinkNode(2);
        root.right = new TreeLinkNode(3);
        root.left.left = new TreeLinkNode(4);
        root.left.right = new TreeLinkNode(5);
        connect(root);
    }
}
