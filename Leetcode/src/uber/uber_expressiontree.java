package uber;

import java.util.Stack;

public class uber_expressiontree {
	public static class Node {
		char val;
		Node left;
		Node right;
		public Node(char val) {
			this.val = val;
			this.left = null;
			this.right = null;
		}
	}
	
	public static class ExpressionTree {
		public Node root;
		public void construct(String s) {
			Stack<Node> stack = new Stack<Node>();
			for(int i = 0; i < s.length(); i++) {
				char c = s.charAt(i);
				Node node = new Node(c);
				if(isOperator(c)) {
					Node right = stack.pop();
					Node left = stack.pop();
					node.right = right;
					node.left = left;
				}
				stack.push(node);
			}
			root = stack.pop();
		}
		
		private boolean isOperator(char c) {
			if(c == '+' || c == '-' || c == '*' 
					|| c == '/' || c == '^') {
				return true;
			}
			return false;
		}
		
		public void inorder() {
			inorder(root);
		}
		
		private void inorder(Node root) {
			if(root != null) {
				inorder(root.left);
				System.out.print(root.val + " ");
				inorder(root.right);
			}
		}
	}

	public static void main(String[] args) {
		String postfix = "ab+ef*g*-";
		ExpressionTree et = new ExpressionTree();
	    et.construct(postfix);
	    System.out.println("infix expression is:");
	    et.inorder();
	}
}
