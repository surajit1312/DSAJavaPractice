/**
 * 
 */
package com.dsa.hashing.easy;

import java.util.Arrays;
import java.util.HashMap;

/**
 * CodingNinjas: Subarray With Given Sum
 * 
 * Link: https://www.codingninjas.com/studio/problems/subarray-with-given-sum_842487
 * 
 * TC: O(n)
 * SC: O(n)
 * 
 */
public class P3_SubArray_With_Given_Sum {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 0, 4, 5, 0 };
		int sum = 9;
		int[] findIndices = subarraySumBruteForce(arr, sum);
		int[] findIndicesSubArraySum = subarraySum(arr, sum);
		System.out.println("Indices with Sub-Array sum " + sum + " in " + Arrays.toString(arr) + " is : "
				+ Arrays.toString(findIndices));
		System.out.println("Indices with Sub-Array sum " + sum + " in " + Arrays.toString(arr) + " is : "
				+ Arrays.toString(findIndicesSubArraySum));
	}

	private static int[] subarraySumBruteForce(int[] arr, long sum) {
		int[] indices = { -1, -1 };
		for (int i = 0; i < arr.length; i++) {
			for (int j = i; j < arr.length; j++) {
				int currentSum = 0;
				for (int k = i; k <= j; k++) {
					currentSum += arr[k];
					if (currentSum == sum) {
						indices[0] = i;
						indices[1] = k;
						break;
					}
				}
			}
		}
		return indices;
	}

	private static int[] subarraySum(int[] arr, long sum) {
		int[] indices = { -1, -1 };
		HashMap<Long, Long> map = new HashMap<Long, Long>();
		long currentSum = 0;

		for (int i = 0; i < arr.length; i++) {
			currentSum += arr[i];
			if (currentSum == sum) {
				indices[0] = 0;
				indices[1] = i;
				break;
			}
			if (!map.containsKey(currentSum - sum)) {
				map.put(currentSum, (long) i);
			} else {
				indices[0] = (int) (map.get(currentSum - sum) + 1);
				indices[1] = i;
				break;
			}
		}
		return indices;
	}

}
