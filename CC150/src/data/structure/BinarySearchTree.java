package data.structure;

import java.util.ArrayList;


public class BinarySearchTree {
	public class TreeNode {
    	public int data;
    	public TreeNode left;
    	public TreeNode right;
    	
    	public TreeNode(int data) {
    		this.data = data;
    	}
    	
    	public void display() {   
            System. out.print("{" + data + "}");  
        }
    }
	
	public TreeNode root;
	public BinarySearchTree() {
		root = null;
	}
	
	public BinarySearchTree(TreeNode root) {
		this.root = root;
	}
	
	public TreeNode find(int data) {
		TreeNode curr = root;
		while(curr.data != data) {
			if(data < curr.data) {
				curr = curr.left;
			} else {
				curr = curr.right;
			}
			if(curr == null) {
				return null;
			}
		}
		return curr;
	}
	
	public void insert(int data) {
		TreeNode newNode = new TreeNode(data);
		if(root == null) {
			root = newNode;
		} else {
			TreeNode curr = root;
			TreeNode parent;
			while(true) {
				parent = curr;
				if(data < curr.data) {
					curr = curr.left;
					if(curr == null) {
						parent.left = newNode;
						return;
					}
				} else {
					curr = curr.right;
					if(curr == null) {
						parent.right = newNode;
						return;
					}
				}
			}			
		}
	}
	
	public boolean delete(int data) {
		TreeNode curr = root;
		TreeNode parent = root;
		boolean isLeftChild = true;
		
		while(curr.data != data) {
			parent = curr;
			if(data < curr.data) {
				isLeftChild = true;
				curr = curr.left;
			} else {
				isLeftChild = false;
				curr = curr.right;
			}
			
			if(curr == null) {
				return false;
			}
		}
		
		if(curr.left == null && curr.right == null) {
			if(curr == root) {
				root = null;
			} else if(isLeftChild) {
				parent.left = null;
			} else {
				parent.right = null;
			}
		} else if(curr.right == null) {
			if(curr == root) {
				root = curr.left;
			} else if(isLeftChild) {
				parent.left = curr.left;
			} else {
				parent.right = curr.left;
			}
		} else if(curr.left == null) {
			if(curr == root) {
				root = curr.right;
			} else if(isLeftChild) {
				parent.left = curr.right;
			} else {
				parent.right = curr.right;
			}
		} else {
			TreeNode successor = getSuccessor(curr);
			if(curr == root) {
				root = successor;
			} else if(isLeftChild) {
				parent.left = successor;
			} else {
				parent.right = successor;
			}
			
			successor.left = curr.left;
		}
		return true;
	}
	
	private TreeNode getSuccessor(TreeNode delNode) {
		TreeNode parent = delNode;
		TreeNode succ = delNode;
		TreeNode curr = delNode.right;
		
		while(curr != null) {
			parent = succ;
			succ = curr;
			curr = curr.left;
		}
		
		if(succ != delNode.right) {
			parent.left = succ.right;
			succ.right = delNode.right;
		}
		
		return succ;
	}
	
	public void traverse(int type) {
		switch(type) {
		case 1 : 
			System.out.print("Preorder:          ");
			preOrder(root);
			break;
		case 2:
			System.out.print("Inorder:           ");
			inOrder(root);
			break;
		case 3:
			System.out.print("Postorder:         ");
			postOrder(root);
			break;
		case 4:
			System.out.print("Levelorder:     ");
			levelOrder(root);
			break;
		case 5 : 
			System.out.print("PreorderWithStack: ");
			preOrderWithStack(root);
			break;
		case 6:
			System.out.print("InorderWithStack:  ");
			inOrderWithStack(root);
			break;
		case 7:
			System.out.print("PostorderWithStack:");
			postOrderWithStack(root);
			break;
		}		
		System.out.println();
	}
	
	private void preOrder(TreeNode root) {
		if(root != null) {
			System.out.print(root.data + " ");
			preOrder(root.left);
			preOrder(root.right);
		}
	}
	
	private void preOrderWithStack(TreeNode root) {
		if(root != null) {
			Stack<TreeNode> stack = new Stack<TreeNode>();
	      
	        stack.push(root);
	        while(!stack.isEmpty()) {
	            TreeNode node = stack.pop();
	            System.out.print(node.data + " ");
	            if(node.right != null) {
	                stack.push(node.right);
	            } 
	            if(node.left != null) {
	                stack.push(node.left);
	            }
	        }
		}
    }
	
	private void inOrder(TreeNode root) {
		if(root != null) {
			inOrder(root.left);
			System.out.print(root.data + " ");
			inOrder(root.right);
		}
	}
	
	private void inOrderWithStack(TreeNode root) {
		if(root != null) {
	        Stack<TreeNode> stack = new Stack<TreeNode>();
	        TreeNode pNode = root;
	        
	        while(!stack.isEmpty() || pNode != null) {
	            if(pNode != null) {
	                stack.push(pNode);
	                pNode = pNode.left;
	            } else {
	                TreeNode tNode = stack.pop();
	                System.out.print(tNode.data + " ");
	                pNode = tNode.right;
	            }
	        }
		}
	}
	
	private void postOrder(TreeNode root) {
		if(root != null) {
			postOrder(root.left);
			postOrder(root.right);
			System.out.print(root.data + " ");
		}
	}	
	
	private void postOrderWithStack(TreeNode root) {
		if(root != null) {		
			Stack<TreeNode> stack = new Stack<TreeNode>();
	        TreeNode prev = null;
	        TreeNode curr = root;
	        
	        stack.push(root);
	        while(!stack.isEmpty()) {
	            curr = stack.peek();
	            if(prev == null || prev.left == curr || prev.right == curr) { // traverse down
	                if(curr.left != null) {
	                    stack.push(curr.left);
	                } else if(curr.right != null) {
	                    stack.push(curr.right);
	                }
	            } else if(curr.left == prev) { // traverse up
	                if(curr.right != null) {
	                    stack.push(curr.right);
	                }
	            } else {
	            	System.out.print(curr.data + " ");
	                stack.pop();
	            }
	            prev = curr;
	        }
	    }
    }
	
	private void levelOrder(TreeNode root) {
        if(root != null) {
	        Queue<TreeNode> queue = new Queue<TreeNode>();
	        queue.enqueue(root);
	        
	        while(!queue.isEmpty()) {
	            ArrayList<Integer> list = new ArrayList<Integer>();
	            int size = queue.size();
	            for(int i = 0; i < size; i++) {
	                TreeNode node = queue.dequeue();
	                list.add(node.data);
	                if(node.left != null) {
	                    queue.enqueue(node.left);
	                }
	                if(node.right != null) {
	                    queue.enqueue(node.right);
	                }
	            }
	            for(int value : list) {
	            	System.out.print(value + " ");
	            }
	        }
        }
    }	
	
	public void displayAll() {
		Stack<TreeNode> gStack = new Stack<TreeNode>();
		gStack.push(root);
		int nSpaces = 48;
		boolean isRowEmpty = false;
		System.out.println( " .................................................................... " );
		while(!isRowEmpty) {
			Stack<TreeNode> lStack = new Stack<TreeNode>();
			isRowEmpty = true;
			for(int i = 0; i < nSpaces; i++) {
				System.out.print(" ");
			}
			while(!gStack.isEmpty()) {
				TreeNode temp = gStack.pop();
				if(temp != null) {
					System.out.print(temp.data);
					lStack.push(temp.left);
					lStack.push(temp.right);
					if(temp.left != null || temp.right != null) {
						isRowEmpty = false;
					} else {
						System.out.print("..");
						lStack.push(null);
						lStack.push(null);
					}
					
					for(int i = 0; i < nSpaces * 2 - 6; i++) {
						System.out.print(" ");
					}
				}
			}
			System.out.println();
			nSpaces /= 2;
			while(!lStack.isEmpty()) {
				gStack.push(lStack.pop());
			}
		}
		System.out.println( " ...................................................................... " );
	}
	
	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree();
		bst.insert(50);
		bst.insert(25);
		bst.insert(75);
		bst.insert(12);
		bst.insert(37);
		bst.insert(43);
		bst.insert(30);
		bst.insert(33);
		bst.insert(87);
		bst.insert(93);
		bst.insert(97);
		
//		bst.displayAll();
//		System.out.println();
		bst.traverse(1);
		bst.traverse(5);
		bst.traverse(2);
		bst.traverse(6);
		bst.traverse(3);
		bst.traverse(7);
		bst.traverse(4);
	}
}
