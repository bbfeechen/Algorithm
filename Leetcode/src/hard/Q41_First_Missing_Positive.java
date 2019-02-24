package hard;

public class Q41_First_Missing_Positive {
	public static int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 1;
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= 0) {
                nums[i] = Integer.MAX_VALUE;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= nums.length) {
                nums[nums[i] - 1] = -Math.abs(nums[nums[i] - 1]);
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }
        return nums.length + 1;

//        if(A == null) {
//            return 0;
//        }
//
//        for(int i = 0; i < A.length; i++) {
//            while(A[i] > 0 && A[i] <= A.length && A[i] != i + 1) {
//                int temp = A[A[i] - 1];
//                if(temp == A[i]) {
//                    break;
//                }
//                A[A[i] - 1] = A[i];
//                A[i] = temp;
//            }
//        }
//
//        for(int i = 0; i < A.length; i++) {
//            if(A[i] != i + 1) {
//                return i + 1;
//            }
//        }
//        return A.length + 1;
    }
	
	public static void main(String[] args) {
        System.out.println(firstMissingPositive(new int[] {3,4,-1,1}));
	}
}
