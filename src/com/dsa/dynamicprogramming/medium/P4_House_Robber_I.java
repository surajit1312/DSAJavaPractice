/**
 * 
 */
package com.dsa.dynamicprogramming.medium;

import java.util.Arrays;

/**
 * 
 * CodingNinjas: House Robber
 * 
 * Link: https://www.codingninjas.com/studio/problems/loot-houses_630510
 * 
 */
public class P4_House_Robber_I {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] houses = { 5, 5, 10, 100, 10, 5 };

		int maxLootRecursion = maxMoneyLootedRecursion(houses);
		System.out.println("Maximum money looted from (non-consective) houses : " + maxLootRecursion);

		int maxLootMemoization = maxMoneyLootedMemoization(houses);
		System.out.println(
				"Maximum money looted from (non-consective) houses (using memoization) : " + maxLootMemoization);

		int maxLootTabulation = maxMoneyLootedTabulation(houses);
		System.out
				.println("Maximum money looted from (non-consective) houses (using tabulation) : " + maxLootTabulation);

		int maxLootBest = maxMoneyLootedBest(houses);
		System.out.println("Maximum money looted from (non-consective) houses (using pointers) : " + maxLootBest);
	}

	/**
	 * 
	 * Using Simple Recursion
	 * 
	 * @param houses
	 * @return
	 */
	private static int maxMoneyLootedRecursion(int[] houses) {
		return findMaxMoneyLootedRecursion(houses, houses.length - 1);
	}

	private static int findMaxMoneyLootedRecursion(int[] houses, int index) {
		if (index == 0) {
			return houses[index];
		}
		if (index < 0) {
			return 0;
		}
		// pick
		int pick = houses[index] + findMaxMoneyLootedRecursion(houses, index - 2);

		// not pick
		int notPick = 0 + findMaxMoneyLootedRecursion(houses, index - 1);

		return Math.max(pick, notPick);
	}

	/**
	 * 
	 * Using Memoization approach
	 * 
	 * TC: O(n)
	 * SC: O(n) + O(n) (due to recursive stack space)
	 * 
	 * @param houses
	 * @return
	 */
	private static int maxMoneyLootedMemoization(int[] houses) {
		int[] dpMax = new int[houses.length];
		Arrays.fill(dpMax, -1);
		int maxLoot = findMaxMoneyLootedMemoization(houses, houses.length - 1, dpMax);
		System.out.println(Arrays.toString(dpMax));
		return maxLoot;
	}

	private static int findMaxMoneyLootedMemoization(int[] houses, int index, int[] dpMax) {
		if (index == 0) {
			dpMax[0] = houses[0];
			return dpMax[0];
		}
		if (index < 0) {
			return 0;
		}

		if (dpMax[index] != -1) {
			return dpMax[index];
		}

		// pick
		int pick = houses[index] + findMaxMoneyLootedMemoization(houses, index - 2, dpMax);

		// not pick
		int notPick = 0 + findMaxMoneyLootedMemoization(houses, index - 1, dpMax);

		return dpMax[index] = Math.max(pick, notPick);
	}

	/**
	 * 
	 * Using Tabulation approach
	 * 
	 * TC: O(n)
	 * SC: O(n)
	 * 
	 * @param houses
	 * @return
	 */
	private static int maxMoneyLootedTabulation(int[] houses) {
		int[] dpTab = new int[houses.length];
		Arrays.fill(dpTab, -1);
		int maxLoot = findMaxMoneyLootedTabulation(houses, houses.length, dpTab);
		System.out.println(Arrays.toString(dpTab));
		return maxLoot;
	}

	private static int findMaxMoneyLootedTabulation(int[] houses, int n, int[] dpTab) {
		dpTab[0] = houses[0];
		for (int i = 1; i < n; i++) {
			// pick
			int pick = i >= 2 ? houses[i] + dpTab[i - 2] : houses[i];

			// not pick
			int notPick = 0 + dpTab[i - 1];

			dpTab[i] = Math.max(pick, notPick);
		}
		return dpTab[n - 1];
	}

	/**
	 * Using Pointers approach
	 * 
	 * TC: O(n)
	 * SC: O(1)
	 */
	private static int maxMoneyLootedBest(int[] houses) {
		int prev2money = 0, prevmoney = 0;
		for (int i = 0; i < houses.length; i++) {
			// take
			int pick = houses[i] + prev2money;

			// not take
			int notPick = 0 + prevmoney;
			int current = Math.max(pick, notPick);
			prev2money = prevmoney;
			prevmoney = current;
		}
		return prevmoney;
	}

}
