package medium;

public class Q255_Verify_Preorder_Sequence_in_Binary_Search_Tree {
    public static boolean verifyPreorder(int[] preorder) {
        if (preorder == null || preorder.length == 0) {
            return true;
        }
        return verify(preorder, 0, preorder.length - 1);
    }

    private static boolean verify(int[] preorder, int start, int end) {
        if (start >= end) {
            return true;
        }
        int root = preorder[start];
        int mid = -1;
        for (int i = start + 1; i <= end; i++) {
            if (mid == -1 && preorder[i] > root) {
                mid = i;
            }
            if (mid != -1 && preorder[i] < root) {
                return false;
            }
        }
        if (mid == -1) {
            return verify(preorder, start + 1, end);
        } else {
            return verify(preorder, start + 1, mid - 1) && verify(preorder, mid, end);
        }
    }


    public static void main(String[] args) {

    }
}
