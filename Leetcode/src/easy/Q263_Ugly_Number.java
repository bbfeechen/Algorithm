package easy;

public class Q263_Ugly_Number {
	public static boolean isUgly(int num) {
		if(num == 0) {
			return false;
		}
		if(num == 1) {
			return true;
		}
		num = maxDivide(num, 2);
		num = maxDivide(num, 3);
		num = maxDivide(num, 5);
		return num == 1 ? true : false;
	}
	
	private static int maxDivide(int num, int div) {
		while(num % div == 0) {
			num /= div;
		}
		return num;
	}
		
	public static void main(String[] args) {
		System.out.println(isUgly(14));
		System.out.println(isUgly(80));
	}
}
