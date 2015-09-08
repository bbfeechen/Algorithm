package basic;

public class BinarySearch {
	public int search(int[] nums, int target) {
		int start = 0;
		int end = nums.length - 1;
		while(start <= end) {
			int mid = (start + end) / 2;
			if(nums[mid] == target) {
				return mid;
			} else if(nums[mid] < target) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
 		}
		return -1;
	}

	public static void main(String[] args) {
		int[] nums = {1, 2, 3, 4, 5, 6, 7, 9, 10, 11};
		BinarySearch bs = new BinarySearch();
		System.out.println("The position is " + bs.search(nums, 9));
	}
}
