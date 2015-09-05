package medium;

import java.util.ArrayList;
import java.util.List;

public class Q114_Flatten_Binary_Tree_to_Linked_List {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		public TreeNode(int val) {
			this.val = val;
		}
	}
	
	public static void flatten(TreeNode root) {
        if(root == null) {
            return;
        }
        List<TreeNode> allNodes = new ArrayList<TreeNode>();
        preorder(root, allNodes);
        int n = allNodes.size();
        for(int i = 0; i < n - 1; i++) {
            allNodes.get(i).left = null;
            allNodes.get(i).right = allNodes.get(i + 1);
        }
        allNodes.get(n - 1).left = allNodes.get(n - 1).right = null;
    }
    
    private static void preorder(TreeNode root, List<TreeNode> allNodes) {
        if(root == null) {
            return;
        }
        allNodes.add(root);
        preorder(root.left, allNodes);
        preorder(root.right, allNodes);
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
