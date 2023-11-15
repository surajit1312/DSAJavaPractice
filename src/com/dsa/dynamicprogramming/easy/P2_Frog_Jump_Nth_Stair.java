/**
 * 
 */
package com.dsa.dynamicprogramming.easy;

import java.util.Arrays;

/**
 * Coding Ninjas Link: https://www.codingninjas.com/studio/problems/frog-jump_3621012
 */
public class P2_Frog_Jump_Nth_Stair {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int n = 7;
		int[] heights = { 7, 4, 4, 2, 6, 6, 3, 4 };
		int minEnergySpentMemoize = frogJumpMemoization(n, heights);
		System.out.println("Minimum total energy spent by frog to jump " + n + "th stair is (memoization): "
				+ minEnergySpentMemoize);
		int minEnergySpentTabulation = frogJumpTabulation(n, heights);
		System.out.println("Minimum total energy spent by frog to jump " + n + "th stair is (tabulation): "
				+ minEnergySpentTabulation);

		int minEnergySpentBestApproach = frogJumpBestApproach(n, heights);
		System.out.println("Minimum total energy spent by frog to jump " + n + "th stair is (tabulation): "
				+ minEnergySpentBestApproach);
	}

	/**
	 * Using Memoization Approach
	 * TC: O(n)
	 * SC: O(n)
	 * @param n
	 * @param heights
	 * @return
	 */
	private static int frogJumpMemoization(int n, int[] heights) {
		int[] dpMin = new int[n + 1];
		Arrays.fill(dpMin, -1);
		return minEnergySpentMemoization(n - 1, heights, dpMin);
	}

	private static int minEnergySpentMemoization(int n, int[] heights, int[] dpMin) {
		if (n == 0) {
			return 0;
		}
		int energyOneStep = Integer.MAX_VALUE;
		int energyTwoStep = Integer.MAX_VALUE;
		if (dpMin[n] != -1) {
			return dpMin[n];
		}
		energyOneStep = minEnergySpentMemoization(n - 1, heights, dpMin) + Math.abs(heights[n] - heights[n - 1]);
		if (n > 1) {
			energyTwoStep = minEnergySpentMemoization(n - 2, heights, dpMin) + Math.abs(heights[n] - heights[n - 2]);
		}
		dpMin[n] = Math.min(energyOneStep, energyTwoStep);
		return dpMin[n];
	}

	/**
	 * Using Tabulation Approach
	 * TC: O(n)
	 * SC: O(n)
	 * @param n
	 * @param heights
	 * @return
	 */
	private static int frogJumpTabulation(int n, int[] heights) {
		int[] dpMin = new int[n + 1];
		Arrays.fill(dpMin, -1);
		return minEnergySpentTabulation(n, heights, dpMin);
	}

	private static int minEnergySpentTabulation(int n, int[] heights, int[] dpMin) {
		dpMin[0] = 0;
		int oneStep = Integer.MAX_VALUE;
		int twoStep = Integer.MAX_VALUE;
		for (int i = 1; i < n; i++) {
			oneStep = dpMin[i - 1] + Math.abs(heights[i] - heights[i - 1]);
			if (i > 1) {
				twoStep = dpMin[i - 2] + Math.abs(heights[i] - heights[i - 2]);
			}
			dpMin[i] = Math.min(oneStep, twoStep);
		}
		return dpMin[n - 1];
	}

	/**
	 * Saving Memory Approach
	 * TC: O(n)
	 * SC: O(1)
	 * @param n
	 * @param heights
	 * @return
	 */
	private static int frogJumpBestApproach(int n, int[] heights) {
		int prev2 = 0, prev1 = 0;
		for (int i = 1; i < n; i++) {
			int oneStep = prev1 + Math.abs(heights[i] - heights[i - 1]);
			int twoStep = Integer.MAX_VALUE;
			if (i > 1) {
				twoStep = prev2 + Math.abs(heights[i] - heights[i - 2]);
			}
			int current = Math.min(oneStep, twoStep);
			prev2 = prev1;
			prev1 = current;
		}
		return prev1;
	}

}
