/**
 * 
 */
package com.dsa.array.easy;

import java.util.ArrayList;

/**
 * 
 * Coding Ninjas Link:
 * https://www.codingninjas.com/studio/problems/sort-an-array-of-0s-1s-and-2s_892977
 * 
 * TC: O(n)
 * SC: O(1)
 */
public class P13_Sort_Array_Of_0s_1s_2s {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] input = { 2, 2, 2, 2, 0, 0, 1, 0, 1, 0 };
		ArrayList<Integer> arr = new ArrayList<Integer>();
		for (int i = 0; i < input.length; i++) {
			arr.add(input[i]);
		}
		sortArray(arr, input.length);
		System.out.println("Sorted array of 0's, 1's and 2's : " + arr);
	}

	private static void sortArray(ArrayList<Integer> arr, int n) {
		int low = 0, mid = 0, high = n - 1;
		while (mid <= high) {
			if (arr.get(mid) == 0) {
				swap(arr, low, mid);
				low++;
				mid++;
			} else if (arr.get(mid) == 1) {
				mid++;
			} else if (arr.get(mid) == 2) {
				swap(arr, mid, high);
				high--;
			}
		}
	}

	private static void swap(ArrayList<Integer> arr, int a, int b) {
		Integer temp = arr.get(a);
		arr.set(a, arr.get(b));
		arr.set(b, temp);
	}

}
