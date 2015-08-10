package easy;

public class Q203_Remove_Linked_List_Elements {
	public static class ListNode {
		int val;
		ListNode next;
		public ListNode(int val) {
			this.val = val;
		}
	}
	
	public static ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(0);
        ListNode prev = dummy;
        dummy.next = head;
        while(head != null) {
            if(head.val == val) {
                prev.next = head.next;
            } else {
                prev = prev.next;
            }
            head = head.next;
        }
        
        return dummy.next;
    }

	public static void main(String[] args) {
		int[] vals = {1, 2, 6, 3, 4, 5, 6};
		ListNode dummy = new ListNode(0);
		ListNode pNode = dummy;
		for(int i = 0; i < vals.length; i++) {
			pNode.next = new ListNode(vals[i]);
			pNode = pNode.next;
		}
		ListNode result = removeElements(dummy.next, 6);
		while(result != null) {
			System.out.print(result.val + " ");
			result = result.next;
		}
	}
}
