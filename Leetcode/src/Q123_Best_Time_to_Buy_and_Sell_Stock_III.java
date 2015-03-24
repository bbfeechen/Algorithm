
public class Q123_Best_Time_to_Buy_and_Sell_Stock_III {
	// The max profit is the sume of max profit before day i and after day i
    public static int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0) {
            return 0;
        }
        
        int[] left = new int[prices.length];
        int[] right = new int[prices.length];
        
        left[0] = 0;
        int min = prices[0];
        for(int i = 1; i < prices.length; i++) {
            min = Math.min(prices[i], min);
            left[i] = Math.max(left[i - 1], prices[i] - min);
        }
        
        right[prices.length - 1] = 0;
        int max = prices[prices.length - 1];
        for(int i = prices.length - 2; i >= 0; i--) {
            max = Math.max(prices[i], max);
            right[i] = Math.max(right[i + 1], max - prices[i]);
        }
        
        int maxProfit = Integer.MIN_VALUE;
        for(int i = 0; i < prices.length; i++) {
            maxProfit = Math.max(maxProfit, left[i] + right[i]);
        }
        return maxProfit;
    }
    
	public static void main(String[] args) {

	}
}
