package linkedin;

public class Search_for_a_Range {
	public static int[] searchRange(int[] A, int target) {
        int[] result = new int[] {-1, -1};
        if(A == null || A.length == 0) {
            return result;
        }
        searchRange(A, result, 0, A.length - 1, target);
        return result;
    }
    
    private static void searchRange(int[] A, int[] result, int start, int end, int target) {
        if(start <= end) {
            int mid = (start + end) / 2;
            if(A[mid] == target) {
                if(mid == 0 || (mid > 0 && A[mid - 1] < A[mid])) {
                    result[0] = mid;
                }
                if(mid == A.length - 1 || (mid < A.length - 1 && A[mid] < A[mid + 1])) {
                    result[1] = mid;
                }
                if(result[0] == -1) {
                    searchRange(A, result, start, mid - 1, target);
                }
                if(result[1] == -1) {
                    searchRange(A, result, mid + 1, end, target);
                }
            } else if(A[mid] < target) {
                searchRange(A, result, mid + 1, end, target); 
            } else {
                searchRange(A, result, start, mid - 1, target);
            }
        }
    }

	public static void main(String[] args) {
		int[] nums = {-3, -2, -1, 0, 0, 0, 0, 3};
		int[] result = searchRange(nums, 0);
		for(int i : result) {
			System.out.print(i + " ");
		}
	}

}
