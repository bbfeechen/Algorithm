package sandbox;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;


public class BST {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		public TreeNode(int val) {
			this.val = val;
			this.left = null;
			this.right = null;
		}
	}
	
	private TreeNode root;
	
	public BST() {
		root = null;
	}
	
	public boolean search(int val) {
		return search(root, val);
	}
	
	private boolean search(TreeNode root, int val) {
		if(root == null) {
			return false;
		}
		if(val == root.val) {
			return true;
		} else if(val < root.val) {
			return search(root.left, val);
		} else {
			return search(root.right, val);
		}
	}
	
	public void insert(int val) {
		root = insert(root, val);
	} 
	
	private TreeNode insert(TreeNode root, int val) {
		if(root == null) {
			return new TreeNode(val);
		}
		if(val < root.val) {
			root.left = insert(root.left, val);
		} else {
			root.right = insert(root.right, val);
		}
		return root;
	}
	
	public void delete(int val) {
		root = delete(root, val);
	}
	
	private TreeNode delete(TreeNode root, int val) {
		if(root == null) {
			return null;
		}
		
		if(val < root.val) {
			root.left = delete(root.left, val);
		} else if(val > root.val) {
			root.right = delete(root.right, val);
		} else {
			if(root.left == null) {
				return root.right; 
			} else if(root.right == null) {
				return root.left;
			} else {
				root.val = getRightMost(root.left);
				root.left = delete(root.left, root.val);
			}
		}
		return root;
	}
	
	private int getRightMost(TreeNode root) {
		while(root.right != null) {
			root = root.right;
		}
		return root.val;
	}
	
	public boolean isEmpty() {
		return root == null;
	}
	
	// ----------------
	public List<Integer> preorder(TreeNode root) {
		List<Integer> result = new ArrayList<Integer>();
		if(root == null) {
			return result;
		}
		Stack<TreeNode> stack = new Stack<TreeNode>();
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
	
	public List<Integer> inorder(TreeNode root) {
		List<Integer> result = new ArrayList<Integer>();
		if(root == null) {
			return result;
		}
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode pNode = root;
		while(!stack.isEmpty() || pNode != null) {
			if(pNode != null) {
				stack.push(pNode);
				pNode = pNode.left;
			} else {
				TreeNode node = stack.pop();
				result.add(node.val);
				pNode = node.right;
			}
		}
		return result;
	}
	
	public List<Integer> postorder(TreeNode root) {
		List<Integer> result = new ArrayList<Integer>();
		if(root == null) {
			return result;
		}
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
	
	public List<List<Integer>> levelorder(TreeNode root) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if(root == null) {
			return result;
		}
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
	
	public String serialize(TreeNode root) {
        // write your code here
        StringBuilder sb = new StringBuilder();
        serialize(root, sb);
        return sb.toString();
    }
    
    private void serialize(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("# ");
        } else {
            sb.append(root.val + " ");
            serialize(root.left, sb);
            serialize(root.right, sb);
        }
    }
    
    public TreeNode deserialize(String data) {
        // write your code here
        if (data == null || data.length() == 0) return null;
        StringTokenizer st = new StringTokenizer(data, " ");
        return deserialize(st);
    }
    
    private TreeNode deserialize(StringTokenizer st){
        if (!st.hasMoreTokens())
            return null;
        String val = st.nextToken();
        if (val.equals("#"))
            return null;
        TreeNode root = new TreeNode(Integer.parseInt(val));
        root.left = deserialize(st);
        root.right = deserialize(st);
        return root;
    }

	public static void main(String[] args) {
		BST bst = new BST();
		bst.insert(3);
		bst.insert(2);
		bst.insert(4);
		bst.insert(1);
		bst.insert(5);
		List<List<Integer>> levelorder = bst.levelorder(bst.root);
		for(List<Integer> list : levelorder) {
			for(int i : list) {
				System.out.print(i + " ");
			}
		}
		System.out.println();
		List<Integer> preorder = bst.preorder(bst.root);
		for(int i : preorder) {
			System.out.print(i + " ");
		}
		System.out.println();
		List<Integer> postorder = bst.postorder(bst.root);
		for(int i : postorder) {
			System.out.print(i + " ");
		}
		System.out.println();
		List<Integer> inorder = bst.inorder(bst.root);
		for(int i : inorder) {
			System.out.print(i + " ");
		}
		System.out.println();
		
		String result = bst.serialize(bst.root);
        System.out.println(result);
        TreeNode root = bst.deserialize(result);
        
        levelorder = bst.levelorder(root);
		for(List<Integer> list : levelorder) {
			for(int i : list) {
				System.out.print(i + " ");
			}
		}
		System.out.println();
		preorder = bst.preorder(root);
		for(int i : preorder) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
}
