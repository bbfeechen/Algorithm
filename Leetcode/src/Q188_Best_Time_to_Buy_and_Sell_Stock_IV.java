
public class Q188_Best_Time_to_Buy_and_Sell_Stock_IV {
	public static int maxProfit(int k, int[] prices) {
        int size = prices.length;
        if(k >= size) {
            return quickSolve(size, prices);
        }
        
        if(size == 0) {
            return 0;
        }
        
        int[][] local = new int[size][k + 1];
        int[][] global = new int[size][k + 1];
        for(int i = 1; i < size; i++) {
            int diff = prices[i] - prices[i - 1];
            for(int j = 1; j <= k; j++) {
                local[i][j] = Math.max(global[i - 1][j - 1] + Math.max(diff, 0), local[i - 1][j] + diff);
                global[i][j] = Math.max(global[i - 1][j], local[i][j]);
            }
        }
        return global[size - 1][k];
    }
    
    private static int quickSolve(int size, int[] prices) {
        int sum = 0;
        for(int i = 0; i < size - 1; i++) {
            if(prices[i + 1] > prices[i]) {
                sum += prices[i + 1] - prices[i];
            }
        }
        return sum;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
