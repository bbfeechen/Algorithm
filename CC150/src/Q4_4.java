import java.util.ArrayList;

import data.structure.BinarySearchTree.TreeNode;
import data.structure.BinarySearchTree;
import data.structure.LinkedList;


public class Q4_4 {
	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree();
		bst.insert(50);
		bst.insert(25);
		bst.insert(75);
		bst.insert(12);
		bst.insert(37);
		bst.insert(60);
		bst.insert(87);
		bst.displayAll();
		ArrayList<LinkedList<TreeNode>> lists = createLevelLinkedList(bst.root);
		for(LinkedList<TreeNode> list : lists) {
			for(TreeNode node : list) {
				node.display();
			} 
			System.out.println();
		}
	}
	
	private static ArrayList<LinkedList<TreeNode>> createLevelLinkedList(TreeNode root) {
		ArrayList<LinkedList<TreeNode>> lists = new ArrayList<LinkedList<TreeNode>>();
		createLevelLinkedList(root, lists, 0);
		return lists;
	}
	
	private static void createLevelLinkedList(TreeNode root, ArrayList<LinkedList<TreeNode>> lists, int level) {
		if(root == null) {
			return; 
		}
		
		LinkedList<TreeNode> list = null;
		if(lists.size() == level) {
			list = new LinkedList<TreeNode>();
			lists.add(list);
		} else {
			list = lists.get(level);
		}
		list.add(root);
		createLevelLinkedList(root.left, lists, level + 1);
		createLevelLinkedList(root.right, lists, level + 1);
	}
}
