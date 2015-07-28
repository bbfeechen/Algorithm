package medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Q103_Binary_Tree_Zigzag_Level_Order_Traversal {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		public TreeNode(int val) {
			this.val = val;
		}
	}
	
	public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        boolean isNormalOrder = true;
        while(!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new ArrayList<Integer>();
            for(int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                level.add(node.val);
                if(node.left != null) {
                    queue.offer(node.left);
                }
                if(node.right != null) {
                    queue.offer(node.right);
                }
            }
            if(!isNormalOrder) {
                Collections.reverse(level);
            }
            result.add(level);
            isNormalOrder = !isNormalOrder;
        }
        return result;
    }
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(6);
		TreeNode p = root;
		p.left = new TreeNode(3);
		p = p.left;
		p.left = new TreeNode(1);
		p.right = new TreeNode(4);
		
		TreeNode q = root;
		q.right = new TreeNode(9);
		q = q.right;
		q.left = new TreeNode(7);
		q.right = new TreeNode(10);
		
		List<List<Integer>> result = zigzagLevelOrder(root);
		for(List<Integer> level : result) {
			for(int i : level) {
				System.out.print(i + " ");
			}
			System.out.println();
		}
	}

}
