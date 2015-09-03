package basic;

public class HeapSort {
	private static int N;
	
	public void sort(int[] nums) {
		heapify(nums);
		for(int i = N; i > 0; i--) {
			swap(nums, 0, i);
			N--;
			sink(nums, 0);
		}
	}
	
	private void heapify(int[] nums) {
		N = nums.length - 1;
		for(int i = N / 2; i >= 0; i--) {
			sink(nums, i);
		}
	}
	
	private void sink(int[] nums, int i) {
		int left = 2 * i;
		int right = 2 * i + 1;
		int max = i;
		if(left <= N && nums[left] > nums[i]) {
			max = left;
		}
		if(right <= N && nums[right] > nums[max]) {
			max = right;
		}
		if(max != i) {
			swap(nums, i, max);
			sink(nums, max);
		}
	}
	
	private void swap(int[] nums, int src, int dst) {
		int temp = nums[src];
		nums[src] = nums[dst];
		nums[dst] = temp;
	}

	public static void main(String[] args) {
		int[] nums = {1, 3, 2, 4, 5, 6, 8, 10, 9, 7};
		HeapSort hs = new HeapSort();
		hs.sort(nums);
		for(int num : nums) {
			System.out.print(num + " ");
		}
	}
}
