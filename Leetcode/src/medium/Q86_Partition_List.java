package medium;


public class Q86_Partition_List {
	public static class ListNode {
	     int val;
	     ListNode next;
	     ListNode(int x) { val = x; }
	}
	
	public static ListNode partition(ListNode head, int x) {
        ListNode smallerdummy = new ListNode(0);
        ListNode smaller = smallerdummy;
        ListNode biggerdummy = new ListNode(0);
        ListNode bigger = biggerdummy;
        
        while(head != null) {
            if(head.val >= x) {
                bigger.next = head;
                bigger = bigger.next;
            } else {
                smaller.next = head;
                smaller = smaller.next;
            }
            head = head.next;
        }
        
        smaller.next = biggerdummy.next;
        bigger.next = null;
        return smallerdummy.next;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
