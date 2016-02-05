package snapchat;

public class ReverseImmutableList {
	public final static class ListNode {
		final int val;
		final ListNode next;
		public ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}
	
	public static void print(ListNode head) {
		while(head != null) {
			System.out.print(head.val + " ");
			head = head.next;
		}
		System.out.println();
	}
	
	public static ListNode reverse(ListNode head) {
		return helper(head, null);
	}
	
	private static ListNode helper(ListNode head, ListNode result) {
		if(head == null) {
			return result;
		}
		ListNode copy = new ListNode(head.val, result);
		return helper(head.next, copy);
	}

	public static void main(String[] args) {
		ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, null))));
		print(head);
		ListNode newhead = reverse(head);
		print(newhead);
	}
}
