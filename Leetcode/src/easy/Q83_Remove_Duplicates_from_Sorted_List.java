package easy;


public class Q83_Remove_Duplicates_from_Sorted_List {
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
        
        while(head != null && head.next != null) {
            if(head.val == head.next.val) {
                head.next = head.next.next;
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
