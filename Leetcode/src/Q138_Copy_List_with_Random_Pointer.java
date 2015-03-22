import java.util.HashMap;


public class Q138_Copy_List_with_Random_Pointer {
    public static class RandomListNode {
	    int label;
	    RandomListNode next, random;
	    RandomListNode(int x) { this.label = x; }
	};
	
    public static RandomListNode copyRandomList(RandomListNode head) {
        if(head == null) {
            return null;
        }
        HashMap<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
        RandomListNode dummy = new RandomListNode(0);
        RandomListNode pre = dummy, newNode;
        
        while(head != null) {
            if(map.containsKey(head)) {
                newNode = map.get(head);
            } else {
                newNode = new RandomListNode(head.label);
                map.put(head, newNode);
            }
            
            pre.next = newNode;
            if(head.random != null) {
                if(map.containsKey(head.random)) {
                    newNode.random = map.get(head.random);
                } else {
                    newNode.random = new RandomListNode(head.random.label);
                    map.put(head.random, newNode.random);
                }
            }
            
            pre = newNode;
            head = head.next;
        }
        
        return dummy.next;
    }
    
	public static void main(String[] args) {

	}
}
