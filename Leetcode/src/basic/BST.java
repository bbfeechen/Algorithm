package basic;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class BST {
	private class TreeNode {
		private int val;
		private TreeNode left;
		private TreeNode right;
		
		private TreeNode(int val) {
			this.val = val;
			this.left = null;
			this.right = null;
		}
	}
	
	private TreeNode root;
	
	public boolean isEmpty() {
		return root == null;
	}
	
	public boolean search(int val) {
		return search(root, val);
	}
	
	private boolean search(TreeNode node, int val) {
		if(node == null) {
			return false;
		}
		if(node.val == val) {
			return true;
		} else if(node.val < val) {
			return search(node.right, val);
		} else {
			return search(node.left, val);
		}
	}
	
	public void insert(int val) {
		root = insert(root, val);
	}
	
	private TreeNode insert(TreeNode node, int val) {
		if(node == null) {
			return new TreeNode(val);
		}
		if(node.val == val) {
			node.val = val;
		} else if(node.val < val) {
			node.right = insert(node.right, val);
		} else {
			node.left = insert(node.left, val);
		}
		return node;
	}
	
	public void delete(int val) {
		root = delete(root, val);
	}
	
	private TreeNode delete(TreeNode node, int val) {
		if(node == null) {
			return null;
		}
		if(node.val < val) {
			node.left = delete(node.left, val);
		} else if(node.val > val) {
			node.right = delete(node.right, val);
		} else {
			if(node.left == null) {
				return node.right;
			} else if(node.right == null) {
				return node.left;
			} else {
				node.val = getRightMost(node.left);
				node.left = delete(node.left, node.val);
			}
		}
		return node;
	}
	
	private int getRightMost(TreeNode node) {
		while(node.right != null) {
			node = node.right;
		}
		return node.val;
	}
	
	public List<Integer> inOrderTraversal(TreeNode root) {
		List<Integer> result = new ArrayList<Integer>();
		Stack<TreeNode> stack = new Stack();
		TreeNode pNode = root;
		while(!stack.isEmpty() || pNode != null) {
			if(pNode != null) {
				stack.push(pNode);
				pNode = pNode.left;
			} else {
				pNode = stack.pop();
				result.add(pNode.val);
				pNode = pNode.right;
			}
		}
		return result;
	}
	
	public List<Integer> preOrderTraversal(TreeNode root) {
		List<Integer> result = new ArrayList<Integer>();
		Stack<TreeNode> stack = new Stack();
		stack.push(root);
		while(!stack.isEmpty()) {
			TreeNode node = stack.pop();
			result.add(node.val);
			if(node.right != null) {
				stack.push(node.right);
			}
			if(node.left != null) {
				stack.push(node.left);
			}
		}
		return result;
	}
	
	public List<Integer> postOrderTraversal(TreeNode root) {
		List<Integer> result = new ArrayList<Integer>();
		Stack<TreeNode> s1 = new Stack<TreeNode>();
		Stack<TreeNode> s2 = new Stack<TreeNode>();
		s1.push(root);
		while(!s1.isEmpty()) {
			TreeNode node = s1.pop();
			s2.push(node);
			if(node.left != null) {
				s1.push(node.left);
			}
			if(node.right != null) {
				s1.push(node.right);
			}
		}
		while(!s2.isEmpty()) {
			TreeNode node = s2.pop();
			result.add(node.val);
		}
		return result;
	}
	
	public List<List<Integer>> levelOrderTraversal(TreeNode root) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		while(!queue.isEmpty()) {
			int size = queue.size();
			List<Integer> level = new ArrayList<Integer>();
			for(int i = 0; i < size; i++) {
				TreeNode node = queue.poll();
				level.add(node.val);
				if(node.left != null) {
					queue.offer(node.left);
				}
				if(node.right != null) {
					queue.offer(node.right);
				}
			}
			result.add(level);
		}
		return result;
	}

	public static void main(String[] args) {
		BST bst = new BST();
		bst.insert(3);
		bst.insert(2);
		bst.insert(4);
		bst.insert(1);
		bst.insert(5);
		List<List<Integer>> levelorder = bst.levelOrderTraversal(bst.root);
		for(List<Integer> list : levelorder) {
			for(int i : list) {
				System.out.print(i + " ");
			}
		}
	}
}
