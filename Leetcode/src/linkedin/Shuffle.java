package linkedin;

import java.util.Random;

public class Shuffle {
	public static void shuffle(int[] nums) {
		Random rand = new Random();
		for(int i = 0; i < nums.length; i++) {
			int index = rand.nextInt(nums.length - i) + i;
			swap(nums, i, index);
		}
	}

	private static void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

	public static void main(String[] args) {
		int[] nums = {8, 6, 9, 7, 5, 2, 4, 3, 1};
		shuffle(nums);
		for(int num : nums) {
			System.out.print(num + " ");
		}
	}
}
