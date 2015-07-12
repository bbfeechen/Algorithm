package hard;

public class Q4_Median_of_Two_Sorted_Arrays {
	public static double findMedianSortedArrays(int A[], int B[]) {
        int length = A.length + B.length;
        if(length % 2 == 0) {
            return (findKth(A, B, 0, 0, length / 2) + findKth(A, B, 0, 0, length / 2 + 1)) / 2.0;
        } else {
            return findKth(A, B, 0, 0, length / 2 + 1);
        }
    }
    
    private static int findKth(int[] A, int[] B, int A_start, int B_start, int k) {
        if(A_start > A.length - 1) {
            return B[B_start + k - 1];
        }
        if(B_start > B.length - 1) {
            return A[A_start + k - 1];
        }
        if(k == 1) {
            return Math.min(A[A_start], B[B_start]);
        }
        int A_key = A_start + k / 2 - 1 < A.length ? A[A_start + k / 2 - 1] : Integer.MAX_VALUE;
        int B_key = B_start + k / 2 - 1 < B.length ? B[B_start + k / 2 - 1] : Integer.MAX_VALUE;
        if(A_key < B_key) {
            return findKth(A, B, A_start + k / 2, B_start, k - k / 2);
        } else {
            return findKth(A, B, A_start, B_start + k / 2, k - k / 2);
        }
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}
