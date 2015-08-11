package easy;

public class Q190_Reverse_Bits {
	public static int reverseBits(int n) {
        int result = 0;
        int i = 0;
        while(n != 0) {
            result |= (n & 0x01) << (31 - i);
            i++;
            n >>>= 1;
        }
        return result;
    }

	public static void main(String[] args) {
		System.out.println(reverseBits(43261596));
	}
}
