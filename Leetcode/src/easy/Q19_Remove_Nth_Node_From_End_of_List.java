package easy;

public class Q19_Remove_Nth_Node_From_End_of_List {
	public static class ListNode {
		int val;
		ListNode next;
		public ListNode(int val) {
			this.val = val;
		}
	} 
	public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pNode = dummy;
        
        for(int i = 0; i < n; i++) {
            head = head.next;
        }
        
        while(head != null) {
            head = head.next;
            pNode = pNode.next;
        }
        pNode.next = pNode.next.next;
        
        return dummy.next;
    }

	public static void main(String[] args) {
		ListNode head = new ListNode(0);
		ListNode pNode = head;
		for(int i = 1; i < 6; i++) {
			pNode.next = new ListNode(i);
			pNode = pNode.next;
		}
		ListNode newHead = removeNthFromEnd(head, 2);
		while(newHead != null) {
			System.out.print(newHead.val + " ");
			newHead = newHead.next;
		}
	}

}
