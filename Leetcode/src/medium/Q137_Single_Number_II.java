package medium;

public class Q137_Single_Number_II {
	public static int singleNumber(int[] nums) {
        int res = 0;
        int[] bit = new int[32];
        for(int i = 0; i < 32; i++) {
            for(int num : nums) {
                bit[i] += (num >> i) & 0x01;
                bit[i] %= 3;
            }
            res |= (bit[i] << i);
        }
        return res;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
