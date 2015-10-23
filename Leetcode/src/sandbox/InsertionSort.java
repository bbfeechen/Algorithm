package sandbox;

public class InsertionSort {
	public void sort(int[] nums) {
		for(int i = 0; i < nums.length; i++) {
			for(int j = i; j > 0 && nums[j] < nums[j - 1]; j--) {
				swap(nums, j, j - 1);
			}
		}
	}
	
	private void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

	public static void main(String[] args) {
		int[] nums = {8, 6, 9, 7, 5, 2, 4, 3, 1};
		InsertionSort is = new InsertionSort();
		is.sort(nums);
		for(int num : nums) {
			System.out.print(num + " ");
		}
	}
}
