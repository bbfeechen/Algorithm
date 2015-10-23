package sandbox;

import java.util.Random;

public class QuickSort {
	public void sort(int[] nums) {
		shuffle(nums);
		sort(nums, 0, nums.length);
	}
	
	private void shuffle(int[] nums) {
		Random rand = new Random();
		for(int i = 0; i < nums.length; i++) {
			int index = rand.nextInt(nums.length - i) + i;
			swap(nums, i, index);
		}
	}
	
	private void sort(int[] nums, int start, int end) {
		if(start >= end) {
			return;
		}
		int mid = partition(nums, start, end);
		sort(nums, start, mid - 1);
		sort(nums, mid + 1, end);
	}
	
	private int partition(int[] nums, int start, int end) {
		int pivot = nums[start];
		int i = start + 1;
		int j = end;
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
