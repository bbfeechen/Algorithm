package basic.sort;

import java.util.Random;

public class QuickSort {
	public void sort(int[] nums) {
		shuffle(nums);
		sort(nums, 0, nums.length - 1);
	}
	
	private void shuffle(int[] nums) {
		Random random = new Random(); 
		for(int i = 0; i < nums.length; i++) {
			int r = i + random.nextInt(nums.length - i);
			swap(nums, i, r);
		}
	}
	
	private void sort(int[] nums, int start, int end) {
		if(start >= end) {
			return;
		}
		int j = partition(nums, start, end);
		sort(nums, start, j - 1);
		sort(nums, j + 1, end);
	}
	
	private int partition(int[] nums, int start, int end) {
		int i = start + 1;
		int j = end;
		int pivot = nums[start];
		while(i <= j) {
			if(nums[i] < pivot) {
				i++;
				continue;
			}
			if(nums[j] > pivot) {
				j--;
				continue;
			}
			swap(nums, i, j);
			i++;
			j--;
		}
		swap(nums, start, j);
		return j;
	}
	
	private void swap(int[] nums, int src, int dst) {
		int temp = nums[src];
		nums[src] = nums[dst];
		nums[dst] = temp;
	}

	public static void main(String[] args) {
		int[] nums = {1, 3, 2, 4, 5, 6, 8, 10, 9, 7};
		QuickSort qs = new QuickSort();
		qs.sort(nums);
		for(int num : nums) {
			System.out.print(num + " ");
		}
	}
}
