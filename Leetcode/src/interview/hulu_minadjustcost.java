package interview;

import java.util.ArrayList;

public class hulu_minadjustcost {
//	d[i][j] 代表第i个数调整到j时的最小cost。
//	for each d[i][j], minimum cost = minimum cost d[i-1][j-target ... j+target] + abs(A[i]-j)
    public int MinAdjustmentCost(ArrayList<Integer> A, int target) {
        // write your code here
        int n = A.size();
        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, A.get(i));
        }
        int[][] d = new int[n][max+1];
        for (int j = 0; j <= max; j++) {
            d[0][j] = Math.abs(A.get(0) - j);
        }
        int curMin = 0;
        for (int i = 1; i < n; i++) {
            curMin = Integer.MAX_VALUE;
            for (int j = 0; j <= max; j++) {
                d[i][j] = Integer.MAX_VALUE;
                for (int k = Math.max(0, j-target); k <= Math.min(max, j+target); k++) {
                    d[i][j] = Math.min(d[i][j], d[i-1][k] + Math.abs(A.get(i)-j));
                    curMin = Math.min(curMin, d[i][j]);
                }
            }
        }
        return curMin;
    }
	
	public static void main(String[] args) {
		
	}
}
