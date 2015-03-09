package data.structure;


public class DoubleLinkedList {
	public class Node {
    	public int data;
    	public Node prev;
    	public Node next;
    	
    	public Node(int data) {
    		this.data = data;
    	}
    	
    	public void display() {  
            System. out.print( data + " ");  
        }
    }
	
	private Node first;
	private Node last;
	
	public DoubleLinkedList() {
		this.first = null;
		this.last = null;
	}
	
	public boolean isEmpty() {
		return first == null;
	}
	
	public void insertFirst(int data) {
		Node node = new Node(data);
		if(isEmpty()) {
			last = node;
		} else {
			first.prev = node;
		}
		node.next = first;
		first = node;
	}
	
	public void insertLast(int data) {
		Node node = new Node(data);
		if(isEmpty()) {
			first = node;
		} else {
			last.next = node;
		}
		node.prev = last;
		last = node;
	}
	
	public boolean insertAfter(int key, int data) {
		Node curr = first;
		while(curr.data != key) {
			curr = curr.next;
			if(curr == null) {
				return false;
			}
		}
		
		Node node = new Node(data);
		if(curr == last) {
			node.next = null;
			last = node;
		} else {
			node.next = curr.next;
			curr.next.prev = node;
		}
		node.prev = curr;
		curr.next = node;
		return true;
	}
	
	public Node deleteKey(int key) {
		Node curr = first;
		while(curr.data != key) {
			curr = curr.next;
			if(curr == null) {
				return null;
			}
		}
		if(curr == first) {
			first = curr.next;
		} else {
			curr.prev.next = curr.next;
		}
		
		if(curr == last) {
			last = curr.prev;
		} else {
			curr.next.prev = curr.prev;
		}
		return curr;
	}
	
	public Node deleteFirst() {
		Node temp = first;
		if(first.next == null) {
			last = null;
		} else {
			first.next.prev = null;
		}
		first = first.next;
		return temp;
	}
	
	public Node deleteLast() {
		Node temp = last;
		if(first.next == null) {
			first = null;
		} else {
			last.prev.next = null;
		}
		last = last.prev;
		return temp;
	}
	
	public void displayAllByFirst() {
		Node curr = first;
		while(curr != null) {
			curr.display();
			curr = curr.next;
		}
		System. out.println();
	}
	
	public void displayAllByLast() {
		Node curr = last;
		while(curr != null) {
			curr.display();
			curr = curr.prev;
		}
		System. out.println();
	}
	
	public static void main(String[] args) {
        DoubleLinkedList linkList = new DoubleLinkedList(); 
        linkList.insertFirst(1);
        linkList.insertFirst(2);
        linkList.insertFirst(3);
        linkList.displayAllByFirst();
        linkList.insertFirst(4);
        linkList.insertFirst(5);
        linkList.displayAllByFirst();
        linkList.displayAllByLast();
        linkList.deleteFirst();
        linkList.displayAllByFirst();
        linkList.deleteKey(2);
        linkList.displayAllByFirst();
	}	
}
