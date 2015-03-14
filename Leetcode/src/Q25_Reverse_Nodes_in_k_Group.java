
public class Q25_Reverse_Nodes_in_k_Group {
	public static class ListNode {
		int val;
        ListNode next;
        ListNode(int x) {
        	val = x;
            next = null;
        }
    }
	
	public static ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || k == 1) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        int i = 0;
        while(head != null){
            i++;
            if(i % k ==0){
                pre = reverse(pre, head.next);
                head = pre.next;
            }else {
                head = head.next;
            }
        }
        return dummy.next;
    }
    
    private static ListNode reverse(ListNode pre, ListNode next){
        ListNode last = pre.next;
        ListNode cur = last.next;
        while(cur != next){
            last.next = cur.next;
            cur.next = pre.next;
            pre.next = cur;
            cur = last.next;
        }
        return last;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
