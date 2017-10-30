package medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Q116_Populating_Next_Right_Pointers_in_Each_Node {
	public static class TreeLinkNode {
	     int val;
	     TreeLinkNode left, right, next;
	     TreeLinkNode(int x) { val = x; }
	}
	
	public static void connectRecursively(TreeLinkNode root) {
        if(root == null) {
            return;
        }
        if(root.left != null) {
            root.left.next = root.right;
        }
        if(root.right != null) {
            root.right.next = root.next != null ? root.next.left : null;
        }
        connectRecursively(root.left);
        connectRecursively(root.right);
    }

    public static void connectIteratively(TreeLinkNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeLinkNode> queue = new LinkedList<>();
        queue.offer(root);
        root.next = null;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeLinkNode curr = queue.poll();
                if (curr.left != null) {
                    queue.offer(curr.left);
                    curr.left.next = curr.right;
                }
                if (curr.right != null) {
                    queue.offer(curr.right);
                    curr.right.next = curr.next == null ? null : curr.next.left;
                }
            }
        }
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
