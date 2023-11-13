/**
 * 
 */
package com.dsa.array.medium;

import java.util.Arrays;

/**
 * Coding Ninjas Link:
 * https://www.codingninjas.com/studio/problems/maximum-subarray-sum_630526
 * 
 * TC: O(n)
 * SC: O(1)
 */
public class P2_Maximum_SubArray_Sum {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int n = 9;
		int[] arr = { 1, 2, 7, -4, 3, 2, -10, 9, 1 };
		long maxSubArrSum = maxSubarraySum(arr, n);
		System.out.println("Maximum sub-array sum of " + Arrays.toString(arr) + " is : " + maxSubArrSum);
	}

	/**
	 * Kadane's Algorithm
	 * 
	 * @param arr
	 * @param n
	 * @return
	 */
	private static long maxSubarraySum(int[] arr, int n) {
		long max = arr[0], currentSum = 0;
		for (int i = 0; i < n; i++) {
			currentSum += arr[i];
			if (currentSum < 0) {
				currentSum = 0;
			}
			if (max < currentSum) {
				max = currentSum;
			}
		}
		return max;
	}

}
