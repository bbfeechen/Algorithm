package data.structure;

public class SingleLinkedList {
	public class Node {
    	public int data;
    	public Node next;
    	
    	public Node(int data) {
    		this.data = data;
    	}
    	
    	public void setNext(Node node) {
    		this.next = node;
    	}
    	
    	public void display() {  
            System. out.print( data + " ");  
        }
    }
	
	public Node first;
	public int pos;
	
	public SingleLinkedList() {
		this.first = null;
		this.pos = 0;
	}
	
	public void insertFirst(int data) {
		Node node = new Node(data);
		node.next = first;
		first = node;
	}
	
	public Node deleteFirst() {
		Node temp = first;
		first = temp.next;
		return temp;
	}
	
	public void insertAfter(int index, int data) {
		Node node = new Node(data);
		Node prev = first;
		Node curr = first;
		while(pos != index) {
			prev = curr;
			curr = curr.next;
			pos++;
		}
		node.next = curr;
		prev.next = node;
		pos = 0;
	}
	
	public Node deleteByPos(int index) {
		Node prev = first;
		Node curr = first;
		while(pos != index) {
			prev = curr;
			curr = curr.next;
			pos++;
		}
		if(curr == first) {
			first = first.next;
		} else {
			prev.next = curr.next;
			pos = 0;
		}
		return curr;
	}
	
	public Node deleteByData(int data) {
		Node prev = first;
		Node curr = first;
		while(curr.data != data) {
			if(curr.next == null) {
				return null;
			}
			prev = curr;
			curr = curr.next;
			pos++;
		}
		if(curr == first) {
			first = first.next;
		} else {
			prev.next = curr.next;
			pos = 0;
		}
		return curr;
	}
	
	public Node findByPos(int index) {
		Node curr = first;
		while(pos != index) {
			curr = curr.next;
			pos++;
		}
		return curr;
	}
	
	public Node findByData(int data) {
		Node curr = first;
		while(curr.data != data) {
			if(curr.next == null) {
				return null;
			}
			curr = curr.next;
			pos++;
		}
		return curr;
	}
	
	public void displayAll() {
	   Node current = first;  
       while (current != null) {  
          current.display();  
          current = current. next;  
       }  
       System. out.println();
	}
	
	public static void main(String[] args) {
        SingleLinkedList linkList = new SingleLinkedList();  
        linkList.insertFirst(20);  
        linkList.insertFirst(21);  
        linkList.insertFirst(19);  
         //19,21,20  
        linkList.insertAfter(1, 22); //19,22,21,20  
        linkList.insertAfter(2, 23); //19,22,23,21,20  
        linkList.insertAfter(3, 99); //19,22,23,99,21,20  
        linkList.displayAll();  
        Node node = linkList.deleteFirst();  
        System.out.println("node : " + node.data);  
        linkList.displayAll();  
        node = linkList.deleteByPos(2);  
        System.out.println("node : " + node.data);  
        linkList.displayAll();  
//        linkList.deleteFirst();  
//        Node node = linkList.deleteByData(19);  
//        Node node = linkList.deleteByPos(0);  
//        System. out.println( "node : " + node.data);  
        linkList.displayAll();  
        Node node1 = linkList.findByPos(0);  
        System. out.println( "node1: " + node1.data);  
        Node node2 = linkList.findByData(22);  
        System. out.println( "node2: " + node2.data);
	}
}
