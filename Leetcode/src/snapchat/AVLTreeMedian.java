package snapchat;

import java.util.Deque;
import java.util.LinkedList;

public class AVLTreeMedian {
	private static class Node {
		private Node left;
		private Node right;
		private final int key;
		private int height;
		private int childCount;

		private Node(int value) {
			key = value;
			height = 1;
		}

		@Override
		public String toString() {
			return Integer.toString(key);
		}
	}
	
	public static class AvlTree {
		private Node root;

		public AvlTree(int... keys) {
			if (keys == null || keys.length == 0) {
				throw new IllegalArgumentException("Null or empty array");
			}
			insert(keys);
		}

		private Node insert(Node parent, int key) {
			if (parent == null) {
				return new Node(key);
			}
			if (key < parent.key) {
				parent.left = insert(parent.left, key);
			} else {
				parent.right = insert(parent.right, key);
			}
			return balance(parent);
		}

		private Node balance(Node p) {
			fixHeightAndChildCount(p);
			if (bfactor(p) == 2) {
				if (bfactor(p.right) < 0) {
					p.right = rotateRight(p.right);
				}
				return rotateLeft(p);
			}
			if (bfactor(p) == -2) {
				if (bfactor(p.left) > 0) {
					p.left = rotateLeft(p.left);
				}
				return rotateRight(p);
			}
			return p;
		}

		private Node rotateRight(Node p) {
			Node q = p.left;
			p.left = q.right;
			q.right = p;
			fixHeightAndChildCount(p);
			fixHeightAndChildCount(q);
			return q;
		}

		private Node rotateLeft(Node q) {
			Node p = q.right;
			q.right = p.left;
			p.left = q;
			fixHeightAndChildCount(q);
			fixHeightAndChildCount(p);
			return p;
		}

		private int height(Node p) {
			return p == null ? 0 : p.height;
		}

		private int bfactor(Node p) {
			return height(p.right) - height(p.left);
		}

		public double getMedian() {
			final int leftChildCount = root.left == null ? 0 : root.left.childCount + 1;
			final int rightChildCount = root.right == null ? 0 : root.right.childCount + 1;
			// Let's handle the simplest case
			if (leftChildCount == rightChildCount) {
				return root.key;
			}
			final int nodeCount = leftChildCount + rightChildCount + 1;
			final boolean evenNodes = nodeCount % 2 == 0;
			if (evenNodes) {
				if (leftChildCount == nodeCount / 2) {
					// the root predecessor and the root
					return (root.key + getPredecessor(root)) / 2.0;
				}
				if (rightChildCount == nodeCount / 2) {
					// the root and its successor
					return (root.key + getSuccessor(root)) / 2.0;
				}
			}
			final boolean traverseLeft = leftChildCount > rightChildCount;
			return traverseTreeToFind(leftChildCount, traverseLeft, nodeCount, evenNodes);
		}

		private int getPredecessor(Node node) {
			Node parent = node.left;
			Node current = parent;
			while (current != null) {
				parent = current;
				current = current.right;
			}
			return parent.key;
		}

		private int getSuccessor(Node node) {
			Node parent = node.right;
			Node current = parent;
			while (current != null) {
				parent = current;
				current = current.left;
			}
			return parent.key;
		}

		private double traverseTreeToFind(int leftChildCount, boolean traverseLeft, int nodeCount,
				boolean evenNodes) {

			Node current = traverseLeft ? root.left : root.right;
			int i = traverseLeft ? leftChildCount - 1 : leftChildCount + 1;
			int medianFirstIndex;
			int medianSecondIndex;
			if (!evenNodes) {
				medianFirstIndex = medianSecondIndex = nodeCount / 2;
			} else {
				if (traverseLeft) {
					medianFirstIndex = nodeCount / 2;
					medianSecondIndex = medianFirstIndex - 1;
				} else {
					medianFirstIndex = nodeCount / 2 - 1;
					medianSecondIndex = medianFirstIndex + 1;
				}
			}
			/*
			 * I chose LinkedList rather than ArrayDeque because LinkedList offers
			 * constant time for delete() and insert(). pop() calls removeFirst(),
			 * and push(e) calls addFirst(e).
			 * 
			 * However, if I understand the answer on
			 * http://stackoverflow.com/a/249695/1065835 correctly, the difference
			 * between constant time and amortized constant time is little if we
			 * perform the operation many times.
			 */
			Deque<Node> stack = new LinkedList<>();
			double smallest = 0.0;
			while (true) {
				if (current != null) {
					stack.push(current);
					current = traverseLeft ? current.right : current.left;
				} else {
					Node last = stack.pop();
					if (i == medianFirstIndex) {
						smallest = last.key;
						if (!evenNodes) {
							break;
						}
					} else if (i == medianSecondIndex) {
						smallest += last.key;
						smallest /= 2.0;
						break;
					}
					
					if (traverseLeft) {
						i--;
						current = last.left;
					} else {
						i++;
						current = last.right;
					}
				}
			}
			return smallest;
		}

		private void fixHeightAndChildCount(Node p) {
			int hl = height(p.left);
			int hr = height(p.right);
			p.height = (hl > hr ? hl : hr) + 1;
			p.childCount = 0;
			if (p.left != null) {
				p.childCount = p.left.childCount + 1;
			}
			if (p.right != null) {
				p.childCount += p.right.childCount + 1;
			}
		}

		public void insert(int... keys) {
			for (int key : keys) {
				root = insert(root, key);
			}
		}
	}

	public static void main(String[] args) {
		AvlTree avlTree = new AvlTree(10, 4, 14, 2, 5, 12, 17, 1, 3, 7, 11, 13, 16, 19, 15, 18);
		avlTree.insert(20);
		System.out.println(avlTree.getMedian());
	}
}
