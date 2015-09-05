package medium;

public class Q147_Insertion_Sort_List {
	public static class ListNode {
	     int val;
	     ListNode next;
	     ListNode(int x) { val = x; }
	}
	
	public static ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode(0);
        while(head != null) {
            ListNode pNode = dummy;
            while(pNode.next != null && pNode.next.val < head.val) {
                pNode = pNode.next;
            }
            ListNode temp = head.next;
            head.next = pNode.next;
            pNode.next = head;
            head = temp;
        }
        return dummy.next;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
