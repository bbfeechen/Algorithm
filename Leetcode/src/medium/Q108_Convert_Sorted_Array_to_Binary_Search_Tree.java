package medium;

import medium.Q106_Construct_Binary_Tree_from_Inorder_and_Postorder_Traversal.TreeNode;

public class Q108_Convert_Sorted_Array_to_Binary_Search_Tree {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		public TreeNode(int val) {
			this.val = val;
		}
	}
	
	public static TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBST(nums, 0, nums.length - 1);
    }
    
    private static TreeNode sortedArrayToBST(int[] nums, int start, int end) {
        if(start > end) {
            return null;
        }
        int mid = (end + start) / 2; 
        TreeNode root = new TreeNode(nums[mid]);
        root.left = sortedArrayToBST(nums, start, mid - 1);
        root.right = sortedArrayToBST(nums, mid + 1, end);
        return root;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
