/**
 * 
 */
package com.dsa.array.sort;

import java.util.Arrays;

/**
 * 
 * CodingNinjas: Bubble Sort
 * 
 * Link: https://www.codingninjas.com/studio/problems/bubble-sort_980524
 * 
 * TC: O(n^2)
 * SC: O(1)
 * 
 */
public class P1_Array_Bubble_Sort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] input = { 4, 3, 2, 1 };
		int n = 4;
		bubbleSort(input, n);
		System.out.println("Sorted array (bubble sort) : " + Arrays.toString(input));
	}

	private static void bubbleSort(int[] arr, int n) {
		for (int i = 1; i < n; i++) {
			for (int j = 0; j < n - 1; j++) {
				if (arr[j] > arr[j + 1]) {
					swap(arr, j, j + 1);
				}
			}
		}
	}

	private static void swap(int[] arr, int a, int b) {
		int temp = arr[b];
		arr[b] = arr[a];
		arr[a] = temp;
	}

}
