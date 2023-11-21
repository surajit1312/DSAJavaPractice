/**
 * 
 */
package com.dsa.dynamicprogramming.medium;

import java.util.Arrays;

/**
 * 
 * CodingNinjas: House Robber II
 * 
 * Refer: House Robber I Problem
 * 
 * Link: https://www.codingninjas.com/studio/problems/house-robber-ii_839733
 * 
 */
public class P5_House_Robber_II {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] valueInHouse = { 1, 5, 1, 2, 6 };
		long maxValueLooted = houseRobber(valueInHouse);
		System.out.println(maxValueLooted);
	}

	public static long houseRobber(int[] valueInHouse) {
		long maxMoney1 = 0, maxMoney2 = 0;
		if (valueInHouse == null) {
			return 0;
		}
		if (valueInHouse.length == 1) {
			return valueInHouse[0];
		}
		int[] temp1 = Arrays.copyOfRange(valueInHouse, 0, valueInHouse.length - 1);
		int[] temp2 = Arrays.copyOfRange(valueInHouse, 1, valueInHouse.length);
		
		maxMoney1 = getMaxNonAdjacentSum(temp1);
		maxMoney2 = getMaxNonAdjacentSum(temp2);
		return Math.max(maxMoney1, maxMoney2);
	}

	private static long getMaxNonAdjacentSum(int[] arr) {
		int prev2 = 0;
		int prev = arr[0];
		for (int i = 1; i < arr.length; i++) {
			// take
			int take = i > 1 ? arr[i] + prev2 : arr[i];
			// not take
			int notTake = 0 + prev;

			int current = Math.max(take, notTake);
			prev2 = prev;
			prev = current;
		}
		return prev;
	}

}
