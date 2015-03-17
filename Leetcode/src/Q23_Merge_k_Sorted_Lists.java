import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;


public class Q23_Merge_k_Sorted_Lists {
	public static class ListNode {
		int val;
        ListNode next;
        ListNode(int x) {
        	val = x;
            next = null;
        }
    }
	
	public static ListNode mergeKLists(List<ListNode> lists) {
        if(lists == null || lists.size() == 0) {
            return null;
        }
        
        Queue<ListNode> heap = new PriorityQueue<ListNode>(lists.size(), new ListComparator());
        for(int i = 0; i < lists.size(); i++) {
            if(lists.get(i) != null) {
                heap.offer(lists.get(i));
            }
        }
        
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        while(!heap.isEmpty()) {
            ListNode head = heap.poll();
            tail.next = head;
            tail = head;
            if(head.next != null) {
                heap.offer(head.next);
            }
        }
        return dummy.next;
     }
	 
	 public static class ListComparator implements Comparator<ListNode> {
	     public int compare(ListNode node1, ListNode node2) {
	         return node1.val - node2.val;
	     }
	 }
	public static void main(String[] args) {

	}
}
