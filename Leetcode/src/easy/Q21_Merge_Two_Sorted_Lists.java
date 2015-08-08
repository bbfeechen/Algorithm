package easy;

public class Q21_Merge_Two_Sorted_Lists {
	public static class ListNode {
		int val;
		ListNode next;
		public ListNode(int val) {
			this.val = val;
		}
	}
	
	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode pNode = dummy;
        
        while(l1 != null && l2 != null) {
            if(l1.val < l2.val) {
                pNode.next = l1;
                l1 = l1.next;
            } else {
                pNode.next = l2;
                l2 = l2.next;
            }
            pNode = pNode.next;
        }
        
        if(l1 != null) {
            pNode.next = l1;
        }
        if(l2 != null) {
            pNode.next = l2;
        }
        return dummy.next;
    }

	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		l1.next = new ListNode(3);
		l1.next.next = new ListNode(5);
		ListNode l2 = new ListNode(2);
		l2.next = new ListNode(4);
		l2.next.next = new ListNode(6);

		ListNode l3 = mergeTwoLists(l1, l2);
		while(l3 != null) {
			System.out.print(l3.val + " ");
			l3 = l3.next;
		}
	}

}
