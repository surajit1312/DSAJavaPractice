/**
 * 
 */
package com.dsa.dynamicprogramming.medium;

import java.util.Arrays;

/**
 * CodingNinjas: Minimal Cost
 * 
 * Link: https://www.codingninjas.com/studio/problems/minimal-cost_8180930
 * 
 */
public class P3_Minimum_Total_Cost_In_KJumps {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] height = { 10, 40, 50, 20, 60 };
		int n = 5;
		int k = 3;
		int minCostRecursion = minimizeCost(n - 1, k, height);
		System.out.println("Minimum total cost to jump from stone 1 to stone " + 5 + " with allowed (1 to " + k
				+ ") jumps : " + minCostRecursion);

		int[] dp = new int[n];
		Arrays.fill(dp, -1);
		int minCostMemo = minimizeCostMemo(n - 1, k, height, dp);
		System.out.println(Arrays.toString(dp));
		System.out.println("Minimum total cost to jump from stone 1 to stone " + 5 + " with allowed (1 to " + k
				+ ") jumps (Using Memoization): " + minCostMemo);

		int[] dpTab = new int[n];
		Arrays.fill(dpTab, -1);
		int minCostTabulation = minimizeCostTabulation(n, k, height, dpTab);
		System.out.println(Arrays.toString(dpTab));
		System.out.println("Minimum total cost to jump from stone 1 to stone " + 5 + " with allowed (1 to " + k
				+ ") jumps (Using Tabulation): " + minCostTabulation);
	}

	/**
	 * Using simple recursion
	 * 
	 * @param n
	 * @param k
	 * @param height
	 * @return
	 */
	public static int minimizeCost(int n, int k, int[] height) {
		if (n == 0) {
			return 0;
		}
		int minCost = Integer.MAX_VALUE;
		for (int j = 1; j <= k; j++) {
			if (n >= j) {
				int jumpCost = minimizeCost(n - j, k, height) + Math.abs(height[n] - height[n - j]);
				minCost = Math.min(minCost, jumpCost);
			} else {
				break;
			}
		}
		return minCost;
	}

	/**
	 * Using Memoization approach
	 * 
	 * TC: O(n * k) 
	 * SC: O(n) + O(n)(added O(n) due to recursion stack)
	 * 
	 * @param n
	 * @param k
	 * @param height
	 * @return
	 */
	public static int minimizeCostMemo(int index, int k, int[] height, int[] dp) {
		if (index == 0) {
			dp[0] = 0;
			return 0;
		}
		if (dp[index] != -1) {
			return dp[index];
		}
		int minCost = Integer.MAX_VALUE;
		for (int j = 1; j <= k; j++) {
			if (index >= j) {
				int jumpCost = minimizeCostMemo(index - j, k, height, dp) + Math.abs(height[index] - height[index - j]);
				minCost = Math.min(minCost, jumpCost);
			} else {
				break;
			}
		}
		return dp[index] = minCost;
	}

	/**
	 * Using Tabulation approach
	 * 
	 * TC: O(n * k)
	 * SC: O(n)
	 * 
	 * @param n
	 * @param k
	 * @param height
	 * @return
	 */
	public static int minimizeCostTabulation(int index, int k, int[] height, int[] dpTab) {
		dpTab[0] = 0;

		for (int i = 1; i < index; i++) {
			int minCost = Integer.MAX_VALUE;
			for (int j = 1; j <= k; j++) {
				if (i >= j) {
					int jumpCost = dpTab[i - j] + Math.abs(height[i] - height[i - j]);
					minCost = Math.min(minCost, jumpCost);
				}
			}
			dpTab[i] = minCost;
		}
		return dpTab[index - 1];
	}
}
