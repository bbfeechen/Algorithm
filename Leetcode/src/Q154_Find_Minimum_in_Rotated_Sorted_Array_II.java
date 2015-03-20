
public class Q154_Find_Minimum_in_Rotated_Sorted_Array_II {
	public static int findMin(int[] num) {
        return findMin(num, 0, num.length - 1);
    }
    
    private static int findMin(int[] num, int start, int end) {
        if(start >= end) {
            return num[start];
        }
        
        int mid = (start + end) / 2;
        if(mid < end && num[mid] > num[mid + 1]) {
            return num[mid + 1];
        }
        
        if(start < mid && num[mid - 1] > num[mid]) {
            return num[mid];
        }
        
        if(num[start] == num[mid] || num[mid] == num[end]) {
            return Math.min(findMin(num, start, mid - 1), findMin(num, mid + 1, end));
        }
        
        if(num[mid] > num[end]) {
            return findMin(num, mid + 1, end);
        } else {
            return findMin(num, start, mid - 1);
        }
    }
    
	public static void main(String[] args) {

	}
}
