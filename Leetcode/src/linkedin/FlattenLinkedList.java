package linkedin;

public class FlattenLinkedList {
	
//	public final class Foo implements Serializable {    
//		private static final long serialVersionUID = 1L;    
//		private static class FooLoader {        
//			private static final Foo INSTANCE = new Foo();    
//		}    
//		private Foo() {        
//			if (FooLoader.INSTANCE != null) {            
//				throw new IllegalStateException("Already instantiated");       
//			}    
//		}    
//		public static Foo getInstance() {        
//			return FooLoader.INSTANCE;    
//		}    
//		@SuppressWarnings("unused")    
//		private Foo readResolve() {        
//			return FooLoader.INSTANCE;    
//		}
//	}
	
	
	public static class Node {
		int val;
		Node right;
		Node down;
		public Node(int val) {
			this.val = val;
		}
	}

	public static void push(Node root, int val) {
		Node node = new Node(val);
		node.right = null;
		node.down = root;
		root = node;
	}
	
	public static void print(Node node) {
		while(node != null) {
			System.out.print(node.val + " ");
			node = node.down;
		}
	}
	
	public static Node flatten(Node root) {
		if(root == null || root.right == null) {
			return root;
		}
		return merge(root, flatten(root.right));
	}
	
	private static Node merge(Node a, Node b) {
		if(a == null) {
			return b;
		}
		if(b == null) {
			return a;
		}
		Node res = null;
		if(a.val < b.val) {
			res = a;
			res.down = merge(a.down, b);
		} else {
			res = b;
			res.down = merge(a, b.down);
		}
		return res;
	}
	
	public static void main(String[] args) {
		Node root = null;
		push(root, 30);
		push(root, 8);
		push(root, 7);
		push(root, 5);
		
		push(root.right, 20);
		push(root.right, 10);
		
		push(root.right.right, 50);
		push(root.right.right, 22);
		push(root.right.right, 19);
		
		push(root.right.right, 45);
		push(root.right.right, 40);
		push(root.right.right, 35);
		push(root.right.right, 20);
		
		root = flatten(root);
		print(root);
	}

}
