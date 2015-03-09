import data.structure.SingleLinkedList;
import data.structure.SingleLinkedList.Node;


public class Q2_3 {
	public static void main(String[] args) {
		SingleLinkedList linkList = new SingleLinkedList();  
        linkList.insertFirst(20);  
        linkList.insertFirst(21);  
        linkList.insertFirst(22);
        linkList.insertFirst(23);
        linkList.insertFirst(24);
        Node node = nthToLast(linkList.first, 3);
        deleteNode(node);
        linkList.displayAll();
	}
	
	private static boolean deleteNode(Node n) {
		if(n == null || n.next == null) {
			return false;
		}
		Node next = n.next;
		n.data = next.data;
		n.next = next.next;
		return true;
	}
	
	private static Node nthToLast(Node head, int k) {
		if(k < 0) {
			return null;
		}
		
		Node p1 = head;
		Node p2 = head;
		for(int i = 0; i < k - 1; i++) {
			if(p2 == null) {
				return null;
			}
			p2 = p2.next;
		}
		if(p2 == null) {
			return null;
		}
		
		while(p2.next != null) {
			p1 = p1.next;
			p2 = p2.next;
		}
		return p1;
	}
}
