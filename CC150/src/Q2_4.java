import data.structure.SingleLinkedList;
import data.structure.SingleLinkedList.Node;


public class Q2_4 {
	public static void main(String[] args) {
		SingleLinkedList linkList = new SingleLinkedList();  
        linkList.insertFirst(22);  
        linkList.insertFirst(26);  
        linkList.insertFirst(27);
        linkList.insertFirst(24);
        linkList.insertFirst(25);
        Node node = partition(linkList.first, 25);
        node.display();
	}
	
	private static Node partition(Node node,int x) {
		Node beforeStart = null;
		Node beforeEnd = null;
		Node afterStart = null;
		Node afterEnd = null;
		
		while(node != null) {
			Node next = node.next;
			node.next = null;
			if(node.data > x) {
				if(beforeStart == null) {
					beforeStart = node;
					beforeEnd = beforeStart;
				} else {
					beforeEnd.next = node;
					beforeEnd = node;
				}
			} else {
				if(afterStart == null) {
					afterStart = node;
					afterEnd = afterStart;
				} else {
					afterEnd.next = node;
					afterEnd = node;
				}
			}
			node = next;
		}
		
		if(beforeStart == null) {
			return afterStart;
		}
		
		beforeEnd.next = afterStart;
		return beforeStart;
	}

}
