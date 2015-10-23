package sandbox;

public class SelectionSort {
	public void sort(int[] nums) {
		for(int i = 0; i < nums.length; i++) {
			int min = i;
			for(int j = i + 1; j < nums.length; j++) {
				min = (nums[j] < nums[min] ? j : min);
			}
			swap(nums, i, min);
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
