package medium;


public class Q92_Reverse_Linked_List_II {
	public static class ListNode {
	     int val;
	     ListNode next;
	     ListNode(int x) { val = x; }
	}
	
	public static ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;
        
        for(int i = 1; i < m; i++) {
            head = head.next;
        }
        
        ListNode premNode = head;
        ListNode mNode = head.next;
        ListNode nNode = head.next;
        ListNode postnNode = nNode.next;
        for(int i = m; i < n; i++) {
            ListNode temp = postnNode.next;
            postnNode.next = nNode;
            nNode = postnNode;
            postnNode = temp;
        }
        mNode.next = postnNode;
        premNode.next = nNode;
        return dummy.next;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
