package medium;

public class Q116_Populating_Next_Right_Pointers_in_Each_Node {
	public static class TreeLinkNode {
	     int val;
	     TreeLinkNode left, right, next;
	     TreeLinkNode(int x) { val = x; }
	}
	
	public static void connect(TreeLinkNode root) {
        if(root == null) {
            return;
        }
        if(root.left != null) {
            root.left.next = root.right;
        }
        if(root.right != null) {
            root.right.next = root.next != null ? root.next.left : null;
        }
        connect(root.left);
        connect(root.right);
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
