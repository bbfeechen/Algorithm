package medium;


public class Q143_Reorder_List {
	public static class ListNode {
	     int val;
	     ListNode next;
	     ListNode(int x) { val = x; }
	}
	
	public static void reorderList(ListNode head) {
        if(head == null) {
            return;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode mid = findMiddle(head);
        ListNode tail = reverse(mid.next);
        mid.next = null;
        merge(head, tail);
    }
    
    private static ListNode findMiddle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while(fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
    
    private static ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = head;
        while(curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
        return head;
    }
    
    private static void merge(ListNode t1, ListNode t2) {
        ListNode dummy = new ListNode(0);
        int count = 0;
        while(t1 != null && t2 != null) {
            if(count % 2 == 0) {
                dummy.next = t1;
                t1 = t1.next;
            } else {
                dummy.next = t2;
                t2 = t2.next;
            }
            dummy = dummy.next;
            count++;
        }
        if(t1 != null) {
            dummy.next = t1;
        } else {
            dummy.next = t2;
        }
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
