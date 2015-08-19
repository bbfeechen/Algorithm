package medium;

public class Q50_Pow {
	public static double myPow(double x, int n) {
		if(n < 0) {
			return 1 / helper(x, -n);
		} else {
			return helper(x, n);
		}
	}
	
	private static double helper(double x, int n) {
		if(n == 0) {
			return 1;
		}
		double v = helper(x, n / 2);
		if(n % 2 == 0) {
			return v * v;
		} else {
			return x * v * v;
		}
	}

	public static void main(String[] args) {
		System.out.println(myPow(3.0, 3));
		System.out.println(myPow(2.0, -2));
	}
}
