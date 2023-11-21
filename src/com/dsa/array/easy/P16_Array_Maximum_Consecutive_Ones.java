/**
 * 
 */
package com.dsa.array.easy;

import java.util.Arrays;

/**
 * 
 * CodingNinjas: Maximum Consecutive Ones
 * 
 * Link: https://www.codingninjas.com/studio/problems/maximum-consecutive-ones_3843993
 * 
 * TC: O(n) SC: O(1)
 */
public class P16_Array_Maximum_Consecutive_Ones {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr = { 0, 1, 1, 0, 0, 1, 1, 1 };
		int n = arr.length;
		int maxOnes = consecutiveOnes(n, arr);
		System.out.println("Maximum consecutive 1's in array " + Arrays.toString(arr) + " is : " + maxOnes);
	}

	private static int consecutiveOnes(int n, int[] arr) {
		int maxOnes = 0, currentOnes = 0;
		for (int i = 0; i < n; i++) {
			if (arr[i] == 0) {
				currentOnes = 0;
			} else if (arr[i] == 1) {
				currentOnes++;
			}
			maxOnes = Math.max(maxOnes, currentOnes);
		}
		return maxOnes;
	}

}
