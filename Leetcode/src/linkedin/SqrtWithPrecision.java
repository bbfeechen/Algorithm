package linkedin;

public class SqrtWithPrecision {
	private static final double precision = 0.00001;
	
	public static void main(String[] args) {
		double number = 0.4923423423;
		double min=0, max=0;		
		for (int i=0;;i++) {
			double boundary = Math.pow(5, i);
			if (number < boundary * boundary) {
				min = max;
				max = boundary;
				break;
			}
			max = boundary;
		}
		
		System.out.println(getSqrt(number, min, max));
		System.out.println(Math.sqrt(number));
	}
	
	private static double getSqrt(double num, double min, double max) {
		double mid = (min + max)/2;
		if (Math.abs(num - mid * mid) <= precision) {
			return mid;
		}
		if (num < (mid * mid)) {
			max = mid-precision;
		} else if (num > (mid*mid)) {
			min = mid+precision;
		}
		return getSqrt(num, min, max);
	}
}
