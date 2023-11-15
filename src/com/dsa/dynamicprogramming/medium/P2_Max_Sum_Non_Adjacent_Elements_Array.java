/**
 * 
 */
package com.dsa.dynamicprogramming.medium;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Coding Ninjas Link: https://www.codingninjas.com/studio/problems/maximum-sum-of-non-adjacent-elements_843261
 * 
 */
public class P2_Max_Sum_Non_Adjacent_Elements_Array {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 1, 3, 5, 8, 1, 9 };
		ArrayList<Integer> nums = new ArrayList<Integer>();
		for (Integer i : arr) {
			nums.add(i);
		}
		int maxSum = maximumNonAdjacentSum(nums);
		System.out.println(
				"Maximum sum of non-adjacent elements in array (Recursive Approach) " + nums + " is : " + maxSum);

		int maxSumMemo = maximumNonAdjacentSumMemo(nums);
		System.out.println(
				"Maximum sum of non-adjacent elements in array (Memoization Approach) " + nums + " is : " + maxSumMemo);

		int maxSumTab = maximumNonAdjacentSumTab(nums);
		System.out.println(
				"Maximum sum of non-adjacent elements in array (Tabulation Approach) " + nums + " is : " + maxSumTab);

		int maxSumBest = maximumNonAdjacentSumBest(nums);
		System.out.println(
				"Maximum sum of non-adjacent elements in array (Best Approach) " + nums + " is : " + maxSumBest);
	}

	public static int maximumNonAdjacentSum(ArrayList<Integer> nums) {
		return maxSumNonAdjacentSubsequence(nums, 0, nums.size() - 1);
	}

	/**
	 * Using standard recursion
	 * TC: O(2^n)
	 * SC: Auxiliary Space of Recursion O(n)
	 * @param nums
	 * @param maxSum
	 * @param index
	 * @return
	 */
	private static int maxSumNonAdjacentSubsequence(ArrayList<Integer> nums, int maxSum, int index) {
		if (index == 0) {
			return nums.get(index);
		}
		if (index < 0) {
			return 0;
		}
		// Take
		int take = nums.get(index) + maxSumNonAdjacentSubsequence(nums, maxSum, index - 2);
		// Not Take
		int notTake = 0 + maxSumNonAdjacentSubsequence(nums, maxSum, index - 1);
		return Math.max(take, notTake);
	}

	public static int maximumNonAdjacentSumMemo(ArrayList<Integer> nums) {
		int[] dp = new int[nums.size()];
		Arrays.fill(dp, -1);
		return maxSumNonAdjacentSubsequenceMemo(nums, 0, nums.size() - 1, dp);
	}

	/**
	 * Using Dynamic Programming Memoization Approach 
	 * 
	 * TC: O(n)
	 * SC: O(n) + Auxiliary Space of Recursion O(n)
	 * 
	 * @param nums
	 * @param maxSum
	 * @param index
	 * @return
	 */
	private static int maxSumNonAdjacentSubsequenceMemo(ArrayList<Integer> nums, int maxSum, int index, int[] dp) {
		if (index == 0) {
			return nums.get(index);
		}
		if (index < 0) {
			return 0;
		}
		if (dp[index] != -1) {
			return dp[index];
		}
		// Take
		int take = nums.get(index) + maxSumNonAdjacentSubsequenceMemo(nums, maxSum, index - 2, dp);
		// Not Take
		int notTake = 0 + maxSumNonAdjacentSubsequenceMemo(nums, maxSum, index - 1, dp);
		return dp[index] = Math.max(take, notTake);
	}

	private static int maximumNonAdjacentSumTab(ArrayList<Integer> nums) {
		int[] dp = new int[nums.size()];
		return maxSumNonAdjacentSubsequenceTab(nums, 0, dp);
	}

	/**
	 * Using Dynamic Programming Tabulation Approach 
	 * 
	 * TC: O(n) 
	 * SC: O(n)
	 * 
	 * @param nums
	 * @param maxSum
	 * @param index
	 * @return
	 */
	private static int maxSumNonAdjacentSubsequenceTab(ArrayList<Integer> nums, int index, int[] dp) {
		if (index == 0) {
			dp[0] = nums.get(index);
		}
		for (int i = 1; i < nums.size(); i++) {
			// Take
			int take = i > 1 ? nums.get(i) + dp[i - 2] : nums.get(i);
			// Not Take
			int notTake = 0 + dp[i - 1];
			dp[i] = Math.max(take, notTake);
		}
		return dp[nums.size() - 1];
	}

	/**
	 * Using pointers approach 
	 * 
	 * TC: O(n)
	 * SC: O(1)
	 * 
	 * @param nums
	 * @return
	 */
	private static int maximumNonAdjacentSumBest(ArrayList<Integer> nums) {
		int prev2 = 0, prev1 = 0;
		for (int i = 0; i < nums.size(); i++) {
			// Take
			int take = nums.get(i) + prev2;
			// Not Take
			int notTake = prev1;
			int current = Math.max(take, notTake);
			prev2 = prev1;
			prev1 = current;
		}
		return prev1;
	}

}
