package secret;


public class Q285_Inorder_Successor_in_BST {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode parent;
		public TreeNode(int val) {
			this.val = val;
		}
	}
	
	// 1）with parent pointer
	public static TreeNode inorderSuccessor(TreeNode root, TreeNode node) {
		if (node.right != null) {		
			return minValue(node.right);
		}

		TreeNode parent = node.parent;
		while (parent != null && node == parent.right) {
			node = parent;
			parent = parent.parent;
		}
		return parent;
	}
		
	// 1）without parent pointer	
	public static TreeNode inorderSuccessor2(TreeNode root, TreeNode node) {
		if (node.right != null) {		
			return minValue(node.right);
		}
		
		TreeNode succ = null;
		while(root != null) {
			if(root.val > node.val) {	
				succ = root;		
				root = root.left;
			} else if(root.val < node.val) {		
				root = root.right;
			} else {		
				break;
			}
		}
		return succ;
	}
		
	public static TreeNode minValue(TreeNode node) {
		TreeNode cur = node;
		while (cur.left != null) {
			cur = cur.left;
		}
		return cur;
	}

	public static TreeNode insert(TreeNode node, int val) {
		if (node == null) {
			return new TreeNode(val);
		} else { 			
			TreeNode temp;
			if (val <= node.val) {
				temp = insert(node.left, val);
				node.left = temp;
				temp.parent = node;
			} else {
				temp = insert(node.right, val);
				node.right = temp;
				temp.parent = node;
			}
			return node;
		}
	}

	public static void main(String[] args) {
		TreeNode root = null;
		root = insert(root, 20);
		root = insert(root, 8);
		root = insert(root, 22);
		root = insert(root, 4);
		root = insert(root, 12);
		root = insert(root, 10);
		root = insert(root, 14);

		TreeNode temp = root.left.right.right;
		TreeNode succ = inorderSuccessor(root, temp);
		succ = inorderSuccessor2(root, temp);
		if (succ != null) {
			System.out.println(temp.val + "'s successor is " + succ.val);
		} else {
			System.out.println("error");
		}
	}
}
