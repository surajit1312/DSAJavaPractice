/**
 * 
 */
package com.dsa.binarysearch.easy;

import java.util.Arrays;

/**
 * 
 */
public class P13_Array_Rotation_Times {

	/**
	 * CodingNinjas Link:
	 * https://www.codingninjas.com/studio/problems/rotation_7449070
	 * 
	 * TC: O(log(n) base 2) 
	 * SC: O(1)
	 */
	public static void main(String[] args) {
		int[] arr = { 4, 5, 6, 7, 1, 2, 3 };
		int arrRotationTimes = findKRotation(arr);
		System.out
				.println("Sorted Array " + Arrays.toString(arr) + " has been rotated : " + arrRotationTimes + " times");
	}

	public static int findKRotation(int[] arr) {
		int low = 0, high = arr.length - 1;
		int min = Integer.MAX_VALUE, minIndex = high;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (arr[low] <= arr[high]) {
				if (min > arr[low]) {
					min = arr[low];
					minIndex = low;
				}
			}
			if (arr[mid] >= arr[low]) {
				if (min > arr[low]) {
					min = arr[low];
					minIndex = low;
				}
				low = mid + 1;
			} else {
				if (min > arr[mid]) {
					min = arr[mid];
					minIndex = mid;
				}
				high = mid - 1;
			}
		}
		return minIndex;
	}

}
