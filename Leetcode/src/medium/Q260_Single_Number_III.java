package medium;

public class Q260_Single_Number_III {
	public static int[] singleNumber(int[] nums) {
		int xor = 0;
		for(int num : nums) {
			xor ^= num;
		}
		int mask = 1;
		while((xor & mask) == 0) {
			mask <<= 1;
		}
		int xorA = 0;
		int xorB = 0;
		for(int num : nums) {
			if((num & mask) == 0) {
				xorA ^= num;
			} else {
				xorB ^= num;
			}
		}
		return new int[] {xorA, xorB};
	}

	public static void main(String[] args) {
		int[] nums = {1, 2, 1, 3, 2, 5};
		int[] res = singleNumber(nums);
		System.out.println(res[0] + ", " + res[1]);
	}
}
