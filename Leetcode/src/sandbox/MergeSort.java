package sandbox;

public class MergeSort {
	public void sort(int[] nums) {
		int[] aux = new int[nums.length];
		sort(nums, aux, 0, nums.length);
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
		System.arraycopy(nums, start, aux, start, end - start + 1);
		int i = start;
		int j = mid + 1;
		for(int k = start; k <= end; k++) {
			if(i > mid) {
				nums[k] = aux[j];
				j++;
			} else if(j > end) {
				nums[k] = aux[i];
				i++;
			} else if(aux[i] < aux[j]) {
				nums[k] = aux[i];
				i++;
			} else {
				nums[k] = aux[j];
				j++;
			}
		}
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
