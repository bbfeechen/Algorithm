package interview;

public class groupon_coinchange {
	public static int count( int S[], int m, int n ) {
	    // We need n+1 rows as the table is consturcted in bottom up manner using 
	    // the base case 0 value case (n = 0)
	    int[][] table = new int[n+1][m];
	    
	    // Fill the enteries for 0 value case (n = 0)
	    for (int i = 0; i < m; i++)
	        table[0][i] = 1;
	 
	    // Fill rest of the table enteries in bottom up manner  
	    for(int i = 1; i < n + 1; i++) {
	        for(int j = 0; j < m; j++) {
	            // Count of solutions including S[j]
	            int x = (i - S[j] >= 0) ? table[i - S[j]][j] : 0;
	 
	            // Count of solutions excluding S[j]
	            int y = (j >= 1) ? table[i][j - 1] : 0;
	 
	            // total count
	            table[i][j] = x + y;
	        }
	    }
	    return table[n][m-1];
	}

	public static void main(String[] args) {
		int[] arr = {2, 5, 3, 6};
	    int m = arr.length;
	    int n = 10;
	    System.out.println(count(arr, m, n));
	}
}
