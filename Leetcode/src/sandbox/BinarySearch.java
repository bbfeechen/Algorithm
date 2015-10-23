package sandbox;

public class BinarySearch {
	public static int binarySearch(int[] nums, int target) {
        //write your code here
        int start = 0;
        int end = nums.length - 1;
        while(start + 1 < end) {
            int mid = (end + start) / 2;
            if(nums[mid] == target) {
                end = mid;
            } else if(nums[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        if(nums[start] == target) {
            return start;
        }
        if(nums[end] == target) {
            return end;
        }
        
        return -1;
    }

	public static void main(String[] args) {
		int[] nums = {3,4,5,6,8,8,8,10,13,14};
		System.out.println(binarySearch(nums, 8));
	}
}
