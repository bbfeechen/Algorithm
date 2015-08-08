package easy;

public class Q237_Delete_Node_in_a_Linked_List {
	public static class ListNode {
		int val;
		ListNode next;
		public ListNode(int val) {
			this.val = val;
		}
	}
	
	public static void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

	public static void main(String[] args) {
		
	}

}
