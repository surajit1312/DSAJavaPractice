/**
 * 
 */
package com.dsa.hashing.easy;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 
 */
public class P4_Longest_SubArray_With_Sum_Zero {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr = { 1, -1, 0, 0, 1 };
		int longestSubArraySumZero = getLongestZeroSumSubarrayLength(arr);
		System.out.println("Longest sub-array with sum 0 in " + Arrays.toString(arr) + " : " + longestSubArraySumZero);
	}

	public static int getLongestZeroSumSubarrayLength(int[] arr) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		int currSize = 0;
		int targetSum = 0;
		int currentSum = 0;
		int result = 0;

		for (int i = 0; i < arr.length; i++) {
			currentSum += arr[i];
			if (currentSum == targetSum) {
				currSize = i + 1;
				if (result < currSize) {
					result = currSize;
				}
			}
			if (!map.containsKey(currentSum - targetSum)) {
				map.put(currentSum - targetSum, i);
			} else {
				currSize = i - map.get(currentSum - targetSum);
				if (result < currSize) {
					result = currSize;
				}
			}
		}
		return result;
	}

}
