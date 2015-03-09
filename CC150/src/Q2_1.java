import data.structure.SingleLinkedList;
import data.structure.SingleLinkedList.Node;


public class Q2_1 {
	public static void main(String[] args) {
		SingleLinkedList linkList = new SingleLinkedList();  
        linkList.insertFirst(20);  
        linkList.insertFirst(21);  
        linkList.insertFirst(19);
        linkList.insertFirst(19);
        linkList.insertFirst(22);
        deleteDups(linkList.first);
        linkList.displayAll();
	}
    
	private static void deleteDups(Node head) {
		if(head == null) {
			return;
		}
		
		Node current = head;
		while(current != null) {
			Node runner = current;
			while(runner.next != null) {
				if(runner.next.data == current.data) {
					runner.next = runner.next.next;
				} else {
					runner = runner.next;
				}
			}
			current = current.next;
		}
	}
}
