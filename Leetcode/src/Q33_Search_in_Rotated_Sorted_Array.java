
public class Q33_Search_in_Rotated_Sorted_Array {
	public static int search(int[] A, int target) {
        int start = 0;
        int end = A.length - 1;
        while(start <= end) {
            int mid = (start + end) / 2;
            if(A[mid] == target) {
                return mid;
            } else if(A[mid] <= A[end]) {
                if(target >= A[mid] && target <= A[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            } else {
                if(target >= A[start] && target <= A[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }
        return -1;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
