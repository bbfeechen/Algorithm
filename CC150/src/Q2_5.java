import data.structure.SingleLinkedList;
import data.structure.SingleLinkedList.Node;


public class Q2_5 {
	public static void main(String[] args) {
		SingleLinkedList l1 = new SingleLinkedList();  
        l1.insertFirst(6);  
        l1.insertFirst(1);  
        l1.insertFirst(7);
        
        SingleLinkedList l2 = new SingleLinkedList();  
        l2.insertFirst(2);  
        l2.insertFirst(9);  
        l2.insertFirst(5);
        
        SingleLinkedList result = new SingleLinkedList(); 
        result.first = addLists(l1.first, l2.first, 0);
        result.displayAll();
	}
	
	private static Node addLists(Node l1, Node l2, int carry) {
		if(l1 == null && l2 == null && carry == 0) {
			return null;
		}
		
		SingleLinkedList linkList = new SingleLinkedList();
		Node result = linkList.new Node(0);
		int value = carry;
		if(l1 != null) {
			value += l1.data;
		}
		
		if(l2 != null) {
			value += l2.data;
		}
		
		result.data = value % 10;
		
		Node more = addLists(l1 == null ? null : l1.next, l2 == null ? null : l2.next,
				value >= 10 ? 1 : 0);
		result.setNext(more);
		return result;
	}
}
