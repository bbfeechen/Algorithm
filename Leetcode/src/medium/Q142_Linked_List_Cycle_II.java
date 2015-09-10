package medium;

import medium.Q141_Linked_List_Cycle.ListNode;

public class Q142_Linked_List_Cycle_II {
	public static class ListNode {
	     int val;
	     ListNode next;
	     ListNode(int x) { val = x; }
	}
	
	public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null || head.next.next == null) {
            return null;
        }
        
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow) {
                break;
            }
        }
        if(fast == null || fast.next == null) {
            return null;
        }
        
        while(head != slow) {
            head = head.next;
            slow = slow.next;
        }
        return head;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
