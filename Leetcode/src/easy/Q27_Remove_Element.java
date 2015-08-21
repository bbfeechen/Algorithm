package easy;

public class Q27_Remove_Element {
	public static int removeElement(int[] nums, int val) {
        int size = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != val) {
                nums[size] = nums[i];
                size++;
            }
        }
        return size;
    }

	public static void main(String[] args) {
		int[] nums = {1, 2, 3, 2, 4, 5, 2};
		System.out.println(removeElement(nums, 2));
	}
}
