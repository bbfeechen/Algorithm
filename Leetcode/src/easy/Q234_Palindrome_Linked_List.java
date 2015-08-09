package easy;

public class Q234_Palindrome_Linked_List {
	public static class ListNode {
		int val;
		ListNode next;
		public ListNode(int val) {
			this.val = val;
		}
	}
	
	public static boolean isPalindrome(ListNode head) {
		ListNode pNode = head;
        
        int length = getLength(head);
        for(int i = 0; i < length / 2; i++) {
            pNode = pNode.next;
        }
        
        pNode = reverse(pNode);
        
        while(pNode != null) {
            if(pNode.val != head.val) {
                return false;
            }
            pNode = pNode.next;
            head = head.next;
        }
        return true;
	}
	
	private static int getLength(ListNode head) {
        int count = 1;
        while(head != null) {
            head = head.next;
            count++;
        }
        return count;
    }
    
    private static ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = null;
        while(curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

	public static void main(String[] args) {
		int num = 1;
		ListNode root = new ListNode(num++);
		ListNode pNode = root;
		for(int i = 0; i < 3; i++) {
			pNode = new ListNode(num++);
			pNode = pNode.next;
		}
		for(int i = 0; i < 3; i++) {
			pNode = new ListNode(num--);
			pNode = pNode.next;
		}
		System.out.println(isPalindrome(root));
	}
}
