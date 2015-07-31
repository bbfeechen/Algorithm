package medium;


public class Q109_Convert_Sorted_List_to_Binary_Search_Tree {
	public static class ListNode {
		int val;
		ListNode next;
		public ListNode(int val) {
			this.val = val;
		}
	}
	
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		public TreeNode(int val) {
			this.val = val;
		}
	}
	
	private static ListNode current;
    
    public static TreeNode sortedListToBST(ListNode head) {
        int length = getLength(head);
        current = head;
        return sortedListToBST(length);
    }
    
    private static TreeNode sortedListToBST(int length) {
        if(length == 0) {
            return null;
        }
        
        TreeNode left = sortedListToBST(length / 2);
        TreeNode root = new TreeNode(current.val);
        current = current.next;
        TreeNode right = sortedListToBST(length - length / 2 - 1);
        root.left = left;
        root.right = right;
        return root;
    }
    
    private static int getLength(ListNode head) {
        int length = 0;
        while(head != null) {
            head = head.next;
            length++;
        }
        return length;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
