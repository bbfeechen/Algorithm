package easy;

public class Q169_Majority_Element {
	public static int majorityElement(int[] nums) {
        int count = 1;
        int major = nums[0];
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] == major) {
                count++;
            } else {
                count--;
                if(count == 0) {
                    major = nums[i];
                    count = 1;
                }
            }
        }
        return major;
    }

	public static void main(String[] args) {

	}

}
