package medium;

import java.util.Stack;

public class Q230_Kth_Smallest_Element_in_a_BST {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		public TreeNode(int val) {
			this.val = val;
		}
	}
	
	public static int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode pNode = root;
        while(!stack.isEmpty() || pNode != null) {
            if(pNode != null) {
                stack.push(pNode);
                pNode = pNode.left;
            } else {
                pNode = stack.pop();
                k--;
                if(k == 0) {
                    return pNode.val;
                }
                pNode = pNode.right;
            }
        }
        return -1;
    }

	public static void main(String[] args) {
		
	}
}
