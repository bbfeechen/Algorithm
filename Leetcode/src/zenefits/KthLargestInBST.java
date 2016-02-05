package zenefits;

public class KthLargestInBST {
	// k refers to the counter. it is a global variable.
	static int k = 0;
	
	//get the nth largest value in BST
	public static void getNthnode(Node root, int n) {
		
		if (root == null) return;
		getNthnode(root.rightChild, n);
		k++;
		if (k == n) {
			System.out.print(root.toString());
		}
		getNthnode(root.leftChild, n);
	}
	
	public static void main(String[] args) {
		 Node a = new Node(8);
	     Node b = new Node(3);
	     Node c = new Node(10);
	     Node d = new Node(1);
	     Node e = new Node(6);
	     Node f = new Node(14);
	     Node g = new Node(4);
	     Node h = new Node(7);
	     Node i = new Node(13);
	     
	     a.leftChild = b;
	     a.rightChild = c;
	     b.leftChild = d;
	     b.rightChild = e;
	     c.rightChild = f;
	     e.rightChild = g;
	     e.rightChild = h;
	     f.leftChild = i;
	     //the third largest value in BST
	     getNthnode(a, 3);		
	}

	static class Node {
	    Node leftChild = null;
	    Node rightChild = null;
	    int value;

	    Node(int value) {
	        this.value = value;
	    }

	    public String toString() {
	        return value + "";
	    }
	}
}
