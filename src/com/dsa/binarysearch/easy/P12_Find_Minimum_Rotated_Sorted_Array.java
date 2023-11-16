/**
 * 
 */
package com.dsa.binarysearch.easy;

import java.util.Arrays;

/**
 * CodingNinjas Link: https://www.codingninjas.com/studio/problems/rotated-array_1093219
 * 
 * TC: O(log(n) base 2)
 * SC: O(1)
 */
public class P12_Find_Minimum_Rotated_Sorted_Array {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr = { 5, 10, 15, 20, 25, 30 };
		int minArr = findMin(arr);
		System.out.println("Minimum in Rotated Sorted Array " + Arrays.toString(arr) + " is : " + minArr);
	}

	private static int findMin(int[] arr) {
		int low = 0, high = arr.length - 1;
		int min = Integer.MAX_VALUE;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (arr[low] <= arr[high]) {
				min = Math.min(min, arr[low]);
			}
			if (arr[mid] >= arr[low]) {
				min = Math.min(min, arr[low]);
				low = mid + 1;
			} else if (arr[mid] <= arr[high]) {
				min = Math.min(min, arr[mid]);
				high = mid - 1;
			}
		}
		return min;
	}

}
