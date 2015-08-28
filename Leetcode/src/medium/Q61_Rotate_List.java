package medium;

public class Q61_Rotate_List {
	public static class ListNode {
		int val;
		ListNode next;
		public ListNode(int val) {
			this.val = val;
		}
	}
	
	public static ListNode rotateRight(ListNode head, int k) {
        if(head == null) {
            return null;
        }
        int length = getLength(head);
        k = k % length;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;
        for(int i = 0; i < k; i++) {
            head = head.next;
        }
        ListNode tail = dummy;
        while(head.next != null) {
            head = head.next;
            tail = tail.next;
        }
        head.next = dummy.next;
        dummy.next = tail.next;
        tail.next = null;
        return dummy.next;
    }
    
    private static int getLength(ListNode head) {
        int length = 0;
        while(head != null) {
            head = head.next;
            length++;
        }
        return length;
    }

	public static void main(String[] args) {
		ListNode dummy = new ListNode(0);
		ListNode root = new ListNode(1);
		dummy.next = root;
		root.next = new ListNode(2);
		root = root.next;
		root.next = new ListNode(3);
		root = root.next;
		root.next = new ListNode(4);
		root = root.next;
		root.next = new ListNode(5);
		root = root.next;
		root.next = null;
		ListNode newRoot = rotateRight(dummy.next, 2);
		while(newRoot != null) {
			System.out.print(newRoot.val + " ");
			newRoot = newRoot.next;
		}
	}
}
