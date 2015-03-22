import java.util.HashMap;


public class Q146_LRU_Cache {
	public static class LRUCache {
	    private class Node {
	        int key;
	        int value;
	        Node prev;
	        Node next;
	        public Node(int key, int value) {
	            this.key = key;
	            this.value = value;
	            this.prev = null;
	            this.next = null;
	        }
	    }
	    
	    private HashMap<Integer, Node> map = new HashMap<Integer, Node>();
	    private Node head = new Node(-1, -1);
	    private Node tail = new Node(-1, -1);
	    private int capacity = 0;
	    
	    public LRUCache(int capacity) {
	        this.capacity = capacity;
	        head.next = tail;
	        tail.prev = head;
	    }
	    
	    public int get(int key) {
	        if(!map.containsKey(key)) {
	            return -1;
	        }
	        Node current = map.get(key);
	        current.next.prev = current.prev;
	        current.prev.next = current.next;
	        move_to_tail(current);
	        return current.value;
	    }
	    
	    public void set(int key, int value) {
	        if(get(key) != -1) {
	            map.get(key).value = value;
	            return;
	        }
	        if(map.size() == capacity) {
	            map.remove(head.next.key);
	            head.next = head.next.next;
	            head.next.prev = head;
	        }
	        Node node = new Node(key, value);
	        map.put(key, node);
	        move_to_tail(node);
	    }
	    
	    private void move_to_tail(Node current) {
	        current.prev = tail.prev;
	        tail.prev.next = current;
	        current.next = tail;
	        tail.prev = current;
	    }
	}
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
