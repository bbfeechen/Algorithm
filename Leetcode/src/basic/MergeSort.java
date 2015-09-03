package basic;

public class MergeSort {
	public void sort(int[] nums) {
		int[] aux = new int[nums.length];
		sort(nums, aux, 0, nums.length - 1);
	}
	
	private void sort(int[] nums, int[] aux, int start, int end) {
		if(start >= end) {
			return;
		}
		int mid = (start + end) / 2;
		sort(nums, aux, start, mid);
		sort(nums, aux, mid + 1, end);
		merge(nums, aux, start, mid, end);
	}
	
	private void merge(int[] nums, int[] aux, int start, int mid, int end) {
		for(int k = start; k <= end; k++) {
			aux[k] = nums[k];
		}
		int i = start;
		int j = mid + 1;
		for(int k = start; k <= end; k++) {
			if(i > mid) {
				nums[k] = aux[j];
				j++;
			} else if(j > end) {
				nums[k] = aux[i];
				i++;
			} else if(aux[j] < aux[i]) {
				nums[k] = aux[j];
				j++;
			} else {
				nums[k] = aux[i];
				i++;
			}
		}
	}
	
	public static void main(String[] args) {
		int[] nums = {1, 3, 2, 4, 5, 6, 8, 10, 9, 7};
		MergeSort ms = new MergeSort();
		ms.sort(nums);
		for(int num : nums) {
			System.out.print(num + " ");
		}
	}
}
