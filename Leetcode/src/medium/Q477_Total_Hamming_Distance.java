package medium;

public class Q477_Total_Hamming_Distance {
    public static int totalHammingDistance(int[] nums) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            int bitCount = 0;
            for (int j = 0; j < nums.length; j++) {
                bitCount += (nums[j] >> i) & 1;
            }
            result += bitCount * (nums.length - bitCount);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(totalHammingDistance(new int[] {4, 14, 2}));
    }
}
