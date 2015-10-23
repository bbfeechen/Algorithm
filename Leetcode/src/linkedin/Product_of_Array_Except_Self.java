package linkedin;

public class Product_of_Array_Except_Self {
	public static int[] productExceptSelf(int[] nums) {
        int[] output = new int[nums.length];
        if(nums == null || nums.length == 0) {
            return null;
        }
        
        int product = 1;
        for(int i = 0; i < nums.length; i++) {
            output[i] = product;
            product *= nums[i];
        }
        
        product = 1;
        for(int i = nums.length - 1; i >= 0; i--) {
            output[i] *= product;
            product *= nums[i];
        }
        return output;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
