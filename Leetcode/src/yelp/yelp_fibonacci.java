package yelp;

public class yelp_fibonacci {
	public static long fibonacciRecursive(long n) {
		if(n < 3) {
			return 1;
		}
		return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
	}
	
	public static long fibonacciDP(int n) {
		long[] results = new long[n + 1];
		results[1] = 1;
		results[2] = 1;
		for(int i = 3; i <= n; i++) {
			results[i] = results[i - 1] + results[i - 2];
		}
		return results[n];
	}

	public static void main(String[] args) {
		System.out.println(fibonacciRecursive(10));
		System.out.println(fibonacciDP(10));
	}
}
