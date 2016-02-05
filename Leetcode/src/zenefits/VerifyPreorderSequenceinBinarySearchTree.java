package zenefits;

import java.util.Stack;

public class VerifyPreorderSequenceinBinarySearchTree {
	public static boolean verifyPreorderIteratively(int[] preorder) {
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
	
	// recursive
	public boolean verifyPreorderRecursively(int[] preorder) {
        if (preorder == null || preorder.length <= 1) {
            return true;
        }
         
        return verifyPreorderHelper(preorder, 0, preorder.length - 1);
    }
     
    private boolean verifyPreorderHelper(int[] preorder, int lo, int hi) {
        if (lo >= hi) {
            return true;
        }
         
        int root = preorder[lo];
        int i = lo + 1;
        while (i <= hi && preorder[i] < root) {
            i++;
        }
         
        int j = i;
        while (j <= hi && preorder[j] > root) {
            j++;
        } 
         
        if (j <= hi) {
            return false;
        }
         
        return verifyPreorderHelper(preorder, lo + 1, i - 1) && 
               verifyPreorderHelper(preorder, i, hi);
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
