/**
 * 
 */
package com.dsa.array.sort;

import java.util.Arrays;

/**
 * CodingNinjas: Merge Sort
 * 
 * Link: https://www.codingninjas.com/studio/problems/merge-sort_920442
 * 
 * TC: O(nlogn)
 * SC: O(n) - Arbitrary space used for recursion stack
 */
public class P2_Array_Merge_Sort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] nums = { 3, 4, 1, 6, 2, 5, 7 };
		int n = 7;
		mergeSort(nums, n);
		System.out.println("Sorted array (merge sort) : " + Arrays.toString(nums));
	}

	private static void mergeSort(int[] arr, int n) {
		sortArray(arr, 0, n - 1);
	}

	private static void sortArray(int[] arr, int low, int high) {
		if (low < high) {
			int mid = low + (high - low) / 2;
			sortArray(arr, low, mid);
			sortArray(arr, mid + 1, high);
			mergeSortedArrays(arr, low, mid, high);
		}
	}

	private static void mergeSortedArrays(int[] arr, int low, int mid, int high) {
		int[] result = new int[arr.length];
		int k = low;
		int i = low, j = mid + 1;

		while (i <= mid && j <= high) {
			if (arr[i] <= arr[j]) {
				result[k] = arr[i];
				i++;
			} else if (arr[i] > arr[j]) {
				result[k] = arr[j];
				j++;
			}
			k++;
		}
		while (i <= mid) {
			result[k] = arr[i];
			i++;
			k++;
		}
		while (j <= high) {
			result[k] = arr[j];
			j++;
			k++;
		}
		for (int p = low; p <= high; p++) {
			arr[p] = result[p];
		}
	}

}
