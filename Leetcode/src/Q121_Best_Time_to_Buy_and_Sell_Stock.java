
public class Q121_Best_Time_to_Buy_and_Sell_Stock {
	public static int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0) {
            return 0;
        }
        int min = prices[0];
        int maxProfit = 0;
        for(int i = 1; i < prices.length; i++) {
            min = Math.min(min, prices[i]);
            maxProfit = Math.max(maxProfit, prices[i] - min);
        }
        return maxProfit;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
