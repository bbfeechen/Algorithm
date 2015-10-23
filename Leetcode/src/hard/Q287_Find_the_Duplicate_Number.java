package hard;

public class Q287_Find_the_Duplicate_Number {
	public static int findDuplicate(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        while(start <= end) {
            int mid = (start + end) / 2;
            int count = 0;
            for(int num : nums) {
                if(num <= mid) {
                    count++;
                }
            }
            if(count <= mid) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return start;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
