/**
 * 
 */
package com.dsa.array.medium;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 
 */
public class P1_Count_All_Array_SubSequences_With_Given_Sum {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr = { 28, 52, 83, 36, 77, 83, 72, 3, 62, 48, 2, 32, 14, 84, 11, 17, 40, 100, 5, 94, 61 };
		int s = 66;
		int countOfSubArraysWithSum = findAllSubarraysWithGivenSum(arr, s);
		System.out.println("Count of all subarrays from " + Arrays.toString(arr) + " with Sum " + s + " is : "
				+ countOfSubArraysWithSum);
	}

	private static int findAllSubarraysWithGivenSum(int[] arr, int s) {
		ArrayList<Integer> ds = new ArrayList<Integer>();
		int[] count = { 0 };
		getAllSubArraysWithSum(arr, s, 0, ds, 0, count);
		return count[0];
	}

	private static void getAllSubArraysWithSum(int[] arr, int targetSum, int combinedSum, ArrayList<Integer> ds,
			int index, int[] count) {
		// Base case
		if (arr == null || arr.length == 0) {
			count[0] = 0;
		}
		if (index == arr.length) {
			if (combinedSum == targetSum) {
				System.out.println(ds); // This line prints all possible combination of sub-arrays
				count[0]++;
			}
			return;
		}
		// Take
		combinedSum += arr[index];
		ds.add(arr[index]);
		getAllSubArraysWithSum(arr, targetSum, combinedSum, ds, index + 1, count);
		// Not Take
		combinedSum -= arr[index]; // backtrack when arr[i] not added
		ds.remove(ds.size() - 1);
		getAllSubArraysWithSum(arr, targetSum, combinedSum, ds, index + 1, count);
	}

}
