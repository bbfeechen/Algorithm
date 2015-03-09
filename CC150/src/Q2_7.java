import data.structure.SingleLinkedList.Node;
import data.structure.SingleLinkedList;
import data.structure.Stack;


public class Q2_7 {
	public static void main(String[] args) {
		SingleLinkedList linkList = new SingleLinkedList();  
		linkList.insertFirst(0);  
		linkList.insertFirst(1);  
		linkList.insertFirst(2);
		linkList.insertFirst(5);
		linkList.insertFirst(3);  
		linkList.insertFirst(1);  
		linkList.insertFirst(0);
		System.out.println(isPalindrome(linkList.first));
	}

	private static boolean isPalindrome(Node head) {
		Node fast = head;
		Node slow = head;
		Stack<Integer> stack = new Stack<Integer>();
		
		while(fast != null && fast.next != null) {
			stack.push(slow.data);
			slow = slow.next;
			fast = fast.next.next;
		}
		
		if(fast != null) {
			slow = slow.next;
		}
		
		while(slow != null) {
			int top = stack.pop().intValue();
			if(top != slow.data) {
				return false;
			}
			slow = slow.next;
		}
		
		return true;
	}
}
