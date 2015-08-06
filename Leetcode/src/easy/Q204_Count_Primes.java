package easy;

public class Q204_Count_Primes {
	public static int countPrimes(int n) {
		if(n <= 2) {
			return 0;
		}
		boolean[] isPrime = new boolean[n];
		for(int i = 0; i < n; i++) {
			isPrime[i] = true;
		}
		for(int i = 2; i <= Math.sqrt(n); i++) {
			if(isPrime[i]) {
				for(int j = 2; j < n; j += i) {
					isPrime[j] = false;
				}
			}
		}
		int count = 0;
		for(int i = 2; i < n; i++) {
			if(isPrime[i]) {
				count++;
			}
		}
		return count;
	}

	public static void main(String[] args) {
		System.out.println(countPrimes(11));
	}
}
