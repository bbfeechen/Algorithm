package medium;


public class Q82_Remove_Duplicates_from_Sorted_List_II {
	public static class ListNode {
		int val;
		ListNode next;
		public ListNode(int val) {
			this.val = val;
		}
	}
	
	public static ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;
        
        while(head.next != null && head.next.next != null) {
            if(head.next.val == head.next.next.val) {
                int val = head.next.val;
                while(head.next != null && val == head.next.val) {
                    head.next = head.next.next;
                }
            } else {
                head = head.next;
            }
        }
        return dummy.next;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
