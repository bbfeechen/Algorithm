package easy;

public class Q206_Reverse_Linked_List {
	public static class ListNode {
		int val;
		ListNode next;
		public ListNode(int val) {
			this.val = val;
		}
	}
	
	public static ListNode reverseList(ListNode head) {
		ListNode prev = null;
		ListNode curr = head;
		ListNode next = null;
		while(curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		return prev;
	}

	public static void main(String[] args) {
		ListNode dummy = new ListNode(0);
		ListNode pNode = dummy;
		for(int i = 1; i < 5; i++) {
			pNode.next = new ListNode(i);
			pNode = pNode.next;
		}
		ListNode node = reverseList(dummy.next);
		while(node != null) {
			System.out.print(node.val + " ");
			node = node.next;
		}
	}
}
