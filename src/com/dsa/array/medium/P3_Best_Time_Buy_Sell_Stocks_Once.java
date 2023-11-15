/**
 * 
 */
package com.dsa.array.medium;

/**
 * Coding Ninjas Link: https://www.codingninjas.com/studio/problems/best-time-to-buy-and-sell-stock_6194560
 * 
 * TC: O(n)
 * SC: O(1)
 */
public class P3_Best_Time_Buy_Sell_Stocks_Once {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] prices = { 7, 1, 5, 4, 3, 6 };
		int maxProfit = bestTimeToBuyAndSellStock(prices);
		System.out.println("Maximum profit that can be earned : " + maxProfit);
	}

	private static int bestTimeToBuyAndSellStock(int[] prices) {
		int maxProfit = 0, min = prices[0];
		for (int i = 1; i < prices.length; i++) {
			int currentProfit = prices[i] - min;
			if (maxProfit < currentProfit) {
				maxProfit = currentProfit;
			}
			if (min > prices[i]) {
				min = prices[i];
			}
		}
		return maxProfit;
	}

}
