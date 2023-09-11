/**
 * 
 */
package com.dsa.array.easy;

/**
 * 
 * Get largest element in an array Link:
 * https://www.codingninjas.com/studio/problems/largest-element-in-the-array-largest-element-in-the-array_5026279
 * 
 */
public class P1_LargestElement {

	public static void main(String[] args) {
		int[] input = { 4, 7, 8, 6, 7, 6 };
		int n = 6;
		int max = largestElement(input, n);
		System.out.println("Largest element in array is: " + max);
	}

	private static int largestElement(int[] arr, int n) {
		int max = arr[0];
		for (int i = 1; i < n; i++) {
			if (arr[i] > max) {
				max = arr[i];
			}
		}
		return max;
	}

}
