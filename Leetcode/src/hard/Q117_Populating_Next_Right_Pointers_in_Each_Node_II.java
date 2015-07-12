package hard;

public class Q117_Populating_Next_Right_Pointers_in_Each_Node_II {
	public static class TreeLinkNode {
	     int val;
	     TreeLinkNode left, right, next;
	     TreeLinkNode(int x) { val = x; }
    }
	
	public static void connect(TreeLinkNode root) {
        if(root == null) {
            return;
        }    
        TreeLinkNode node = root.next;
        while(node != null) {
            if(node.left != null) {
                node = node.left;
                break;
            }
            if(node.right != null) {
                node = node.right;
                break;
            }
            node = node.next;
        }
        
        if(root.right != null) {
            root.right.next = node;
        }
        
        if(root.left != null) {
            root.left.next = (root.right == null ? node : root.right);
        }
        
        connect(root.right);
        connect(root.left);
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
