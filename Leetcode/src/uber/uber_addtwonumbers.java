package uber;

public class uber_addtwonumbers {
	public static class ListNode {
		int val;
		ListNode next;
		public ListNode(int val) {
			this.val = val;
			this.next = null;
		}
	}
	
	public static ListNode addList(ListNode head1, ListNode head2) {
		int length1 = getLength(head1);
		int length2 = getLength(head2);
		
		ListNode node = helper(head1, length1 - length2, head2, length2 - length1);
		if(node.val > 9) {
			ListNode x = new ListNode(1);
			x.next = node;
			node.val = node.val - 10;
			return x;
		}
		return node;
	}
	
	private static ListNode helper(ListNode head1, int length1, ListNode head2, int length2) {
		if(head1 == null || head2 == null) {
			return null;
		}
		ListNode node = helper(length2 > 0 ? head1 : head1.next, length1 - 1, length1 > 0 ? head2 : head2.next, length2 - 1);
		int carry = 0;
		if(node != null && node.val > 9) {
			carry = node.val / 10;
			node.val = node.val % 10;
		}
		carry += length1 <= 0 ? head2.val : 0;
		carry += length2 <= 0 ? head1.val : 0;
		ListNode ret = new ListNode(carry);
		ret.next = node;
		return ret;
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
		ListNode head1 = new ListNode(9);
		head1.next = new ListNode(9);
		head1.next.next = new ListNode(9);
		
		ListNode head2 = new ListNode(1);
		head2.next = new ListNode(8);
		
		ListNode node = addList(head1, head2);
		while(node != null) {
			System.out.print(node.val + " ");
			node = node.next;
		}
	}
}
