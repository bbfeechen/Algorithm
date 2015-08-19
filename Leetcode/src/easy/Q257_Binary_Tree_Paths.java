package easy;

import java.util.ArrayList;
import java.util.List;

public class Q257_Binary_Tree_Paths {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		public TreeNode(int val) {
			this.val = val;
		}
	}
	
	public static List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<String>();
        if(root == null) {
            return result;
        }
        int maxDepth = getDepth(root);
        int[] path = new int[maxDepth];
        dfs(result, path, 0, root);
        return result;
    }
    
    private static int getDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        return Math.max(getDepth(root.left), getDepth(root.right)) + 1;
    }
    
    private static void dfs(List<String> result, int[] path, int depth, TreeNode root) {
        if(root == null) {
            return;
        }
        path[depth] = root.val;
        depth++;
        if(root.left == null && root.right == null) {
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < depth; i++) {
                if(i == 0) {
                    sb.append(path[i] + "");
                } else {
                    sb.append("->" + path[i]);
                }
            }
            result.add(sb.toString());
            return;
        }
        dfs(result, path, depth, root.left);
        dfs(result, path, depth, root.right);
    } 

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		TreeNode left = new TreeNode(2);
		TreeNode right = new TreeNode(3);
		TreeNode leftright = new TreeNode(5);
		root.left = left;
		root.right = right;
		root.left.right = leftright;
		List<String> res = binaryTreePaths(root);
		for(String str : res) {
			System.out.println(str);
		}
	}
}
