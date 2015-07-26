package medium;


public class Q2_Add_Two_Numbers {
	public static class ListNode {
		int val;
		ListNode next;
		public ListNode(int val) {
			this.val = val;
		}
	}
	
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode dummy = new ListNode(0);
        ListNode pNode = dummy;
        int carry = 0;
        while(l1 != null && l2 != null) {
            int sum = l1.val + l2.val + carry;
            pNode.next = new ListNode(sum % 10);
            carry = sum / 10;
            pNode = pNode.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        if(l1 != null) {
            while(l1 != null) {
                int sum = l1.val + carry;
                pNode.next = new ListNode(sum % 10);
                carry = sum / 10;
                pNode = pNode.next;
                l1 = l1.next;
            }
        } else {
            while(l2 != null) {
                int sum = l2.val + carry;
                pNode.next = new ListNode(sum % 10);
                carry = sum / 10;
                pNode = pNode.next;
                l2 = l2.next;
            }
        }
        if(carry != 0) {
            pNode.next = new ListNode(carry);
        }
        return dummy.next;
	}
	
	public static void main(String[] args) {
		ListNode l1 = new ListNode(2);
		ListNode p1 = l1;
		p1.next = new ListNode(4);
		p1 = p1.next;
		p1.next = new ListNode(3);
		
		ListNode l2 = new ListNode(5);
		ListNode p2 = l2;
		p2.next = new ListNode(6);
		p2 = p2.next;
		p2.next = new ListNode(4);
		
		ListNode result = addTwoNumbers(l1, l2);
		while(result != null) {
			System.out.print(result.val + " ");
			result = result.next;
		}
	}
}
