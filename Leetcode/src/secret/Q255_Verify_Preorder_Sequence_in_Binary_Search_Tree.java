package secret;

import java.util.Stack;

public class Q255_Verify_Preorder_Sequence_in_Binary_Search_Tree {
	public static boolean verifyPreorder(int[] preorder) {
        if (preorder == null || preorder.length <= 1) {
            return true;
        }
         
        Stack<Integer> stack = new Stack<Integer>();
        int max = Integer.MIN_VALUE;
         
        for (int num : preorder) {
            if (num < max) {
                return false;
            }
            while (!stack.isEmpty() && num > stack.peek()) {
                max = stack.pop();
            }
            stack.push(num);
        }
         
        return true;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
