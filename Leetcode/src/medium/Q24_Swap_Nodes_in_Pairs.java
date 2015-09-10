package medium;


public class Q24_Swap_Nodes_in_Pairs {
	public static class ListNode {
		int val;
		ListNode next;
		public ListNode(int val) {
			this.val = val;
		}
	}
	
	public static ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;
        
        while(head.next != null && head.next.next != null) {
            ListNode temp = head.next.next.next;
            head.next.next.next = head.next;
            head.next = head.next.next;
            head.next.next.next = temp;
            head = head.next.next;
        }
        return dummy.next;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
