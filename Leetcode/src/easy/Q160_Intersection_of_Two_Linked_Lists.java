package easy;


public class Q160_Intersection_of_Two_Linked_Lists {
	public static class ListNode {
		int val;
		ListNode next;
		public ListNode(int val) {
			this.val = val;
		}
	}
	
	public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lengthA = getLength(headA);
        int lengthB = getLength(headB);
        
        if(lengthA > lengthB) {
            while(lengthA != lengthB) {
                headA = headA.next;
                lengthA--;
            }
        } else {
            while(lengthA != lengthB) {
                headB = headB.next;
                lengthB--;
            }
        }
        
        while(lengthA != 0 && lengthB != 0) {
            if(headA.val == headB.val) {
                return headA;
            }
            headA = headA.next;
            headB = headB.next;
            lengthA--;
            lengthB--;
        }
        return null;
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
		// TODO Auto-generated method stub

	}

}
