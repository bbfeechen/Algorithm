package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class Q314_Binary_Tree_Vertical_Order_Traversal {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val) {
            this.val = val;
        }
    }

    static class OrderNode {
        TreeNode node;
        int order;
        public OrderNode(TreeNode node, int order) {
            this.node = node;
            this.order = order;
        }
    }
    public static List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Map<Integer, List<Integer>> map = new HashMap<>();
        Queue<OrderNode> queue = new LinkedList<>();
        queue.offer(new OrderNode(root, 0));
        int min = 0;
        int max = 0;
        while (!queue.isEmpty()) {
            OrderNode curr = queue.poll();
            if (!map.containsKey(curr.order)) {
                map.put(curr.order, new ArrayList<>());
            }
            map.get(curr.order).add(curr.node.val);
            min = Math.min(curr.order, min);
            max = Math.max(curr.order, max);
            if (curr.node.left != null) {
                queue.offer(new OrderNode(curr.node.left, curr.order - 1));
            }
            if (curr.node.right != null) {
                queue.offer(new OrderNode(curr.node.right, curr.order + 1));
            }
        }
        for (int i = min; i <= max; i++) {
            if (!map.containsKey(i)) {
                continue;
            }
            result.add(map.get(i));
        }
        return result;
    }

    public static void main(String[] args) {

    }
}
