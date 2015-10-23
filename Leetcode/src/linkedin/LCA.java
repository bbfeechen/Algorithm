package linkedin;

public class LCA {
	class Node {
	    int val;
		Node left;
	    Node right;
	    Node parent;
	    public Node(int val) {
	    	this.val = val;
	    }
	}
	
	public Node findLCAWithoutParent(Node root, Node p, Node q) {
	   if (root == null || p == null || q == null) return null;
	   if (root == p || root == q) return root;
	   Node left = findLCAWithoutParent(root.left, p, q);
	   Node right = findLCAWithoutParent(root.right, p, q);
	   if (left != null && right != null) return root;
	   if (left != null) {
	      return left;
	   } else {
	      return right;
	   }
	}
	
	//-------------
	public Node findLCAWithParent(Node root, Node p, Node q) {
	   if (root == null || p == null || q == null) return null;
	   int depth1 = getDepth(root, p);
	   int depth2 = getDepth(root, q);
	   if (depth1 > depth2) {
	      swap(depth1, depth2);
	      swap(p, q);
	   }
	   for (int i = 0; i < depth1 - depth2; i++) {
	      q = q.parent;
	   }
	   while(p != null) {
	      if (p == q) return p;
	      p = p.parent;
	      q = q.parent;
	   }
	   return null;
	}

	public int getDepth(Node root, Node n) {
	   if (root == null || n == null) return 0;
	   int depth = 0;
	   while (root != n) {
	      depth++;
	      n = n.parent;
	   }
	   return depth;
	}

	public void swap(Object a, Object b) {
	   Object tmp = a;
	   a = b;
	   b = tmp;
	}
}
