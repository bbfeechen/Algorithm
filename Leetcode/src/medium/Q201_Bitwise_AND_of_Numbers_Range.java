package medium;

public class Q201_Bitwise_AND_of_Numbers_Range {
	public static int rangeBitwiseAnd(int m, int n) {
		int i = 0;
		while(m != n) {
			m >>= 1;
			n >>= 1;
			i++;
		}
		return m << i;
	}

	public static void main(String[] args) {
		System.out.println(rangeBitwiseAnd(5, 7));
	}
}
