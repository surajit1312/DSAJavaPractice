/**
 * 
 */
package com.dsa.array.sort;

import java.util.ArrayList;
import java.util.List;

/**
 * CodingNinjas: Quick Sort
 * 
 * Link: https://www.codingninjas.com/studio/problems/quick-sort_983625
 * 
 * TC: Average case - O(nlogn) - Worst case - O(n^2)
 * SC: O(n) - Arbitrary space used for recursion stack
 * 
 */
public class P3_Array_Quick_Sort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] nums = { 4, 2, 1, 5, 3 };
		List<Integer> arr = new ArrayList<Integer>();
		for (int i = 0; i < nums.length; i++) {
			arr.add(nums[i]);
		}
		List<Integer> sortedList = quickSort(arr);
		System.out.println("Sorted array (quick sort) : " + sortedList);
	}

	private static List<Integer> quickSort(List<Integer> arr) {
		quickSortHelper(arr, 0, arr.size() - 1);
		return arr;
	}

	private static void quickSortHelper(List<Integer> arr, int low, int high) {
		if (low < high) {
			int pivot = getPivotElementIndex(arr, low, high);
			quickSortHelper(arr, low, pivot - 1);
			quickSortHelper(arr, pivot + 1, high);
		}
	}

	private static int getPivotElementIndex(List<Integer> arr, int low, int high) {
		int i = low, j = high;
		int pivot = low;

		while (i < j) {
			while (arr.get(i) <= arr.get(pivot)) {
				i++;
			}
			while (arr.get(j) > arr.get(pivot)) {
				j--;
			}
			if (i < j) {
				swap(arr, i, j);
			}
		}

		swap(arr, j, pivot);
		return j;
	}

	private static void swap(List<Integer> arr, int a, int b) {
		Integer temp = arr.get(b);
		arr.set(b, arr.get(a));
		arr.set(a, temp);
	}

}
