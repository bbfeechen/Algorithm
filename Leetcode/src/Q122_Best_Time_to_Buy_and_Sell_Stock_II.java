
public class Q122_Best_Time_to_Buy_and_Sell_Stock_II {
	public static int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0) {
            return 0;
        }
        int maxProfit = 0;
        for(int i = 0; i < prices.length - 1; i++) {
            if(prices[i + 1] - prices[i] > 0) {
                maxProfit += (prices[i + 1] - prices[i]);
            }
        }
        return maxProfit;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
