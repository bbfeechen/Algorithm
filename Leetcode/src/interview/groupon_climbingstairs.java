package interview;

public class groupon_climbingstairs {
	static int countWaysUtil(int n, int m)
	{
	    if (n <= 1)
	        return n;
	    int res = 0;
	    for (int i = 1; i<=m && i<=n; i++)
	        res += countWaysUtil(n-i, m);
	    return res;
	}
	 
	// Returns number of ways to reach s'th stair
	static int countWays(int s, int m)
	{
	    return countWaysUtil(s+1, m);
	}

	public static void main(String[] args) {
		System.out.println(countWays(4, 2));
	}
}
