package easy;

public class Q264_Ugly_Number_II {
	public static int nthUglyNumber(int n) {
        if(n == 1) {
            return 1;
        }
        int[] nums = new int[n];
        nums[0] = 1;
        int i2 = 0, i3 = 0, i5 = 0;
        int next2 = 2, next3 = 3, next5 = 5;
        int res = 1;
        for(int i = 1; i < n; i++) {
            res = Math.min(Math.min(next2, next3), next5);
            nums[i] = res;
            if(res == next2) {
                i2++;
                next2 = nums[i2] * 2;
            }
            if(res == next3) {
                i3++;
                next3 = nums[i3] * 3;
            }
            if(res == next5) {
                i5++;
                next5 = nums[i5] * 5;
            }
        }
        return res;
    }

	public static void main(String[] args) {
		System.out.println(nthUglyNumber(8));
		System.out.println(nthUglyNumber(10));
	}
}
