package medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Q199_Binary_Tree_Right_Side_View {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		public TreeNode(int val) {
			this.val = val;
		}
	}
	
	public static List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if(root == null) {
            return result;
        }
        
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        
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
            result.add(level.get(level.size() - 1));
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
		
		List<Integer> result = rightSideView(root);
		for(int i : result) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
}
