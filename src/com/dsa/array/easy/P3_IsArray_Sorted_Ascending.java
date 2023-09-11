/**
 * 
 */
package com.dsa.array.easy;

/**
 * 
 * Check if the array is sorted in non-decreasing order Link:
 * https://www.codingninjas.com/studio/problems/ninja-and-the-sorted-check_6581957
 * 
 */
public class P3_IsArray_Sorted_Ascending {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] input1 = { 1, 2, 3, 4, 5 };
		int n1 = 5;
		int sorted1 = isSorted(n1, input1);
		System.out.println("Is Array sorted: " + sorted1);

		int[] input2 = { 0, 0, 0, 1 };
		int n2 = 4;
		int sorted2 = isSorted(n2, input2);
		System.out.println("Is Array sorted: " + sorted2);

		int[] input3 = { 4, 5, 4, 4, 4 };
		int n3 = 5;
		int sorted3 = isSorted(n3, input3);
		System.out.println("Is Array sorted: " + sorted3);
	}

	private static int isSorted(int n, int[] a) {
		for (int i = 1; i < n; i++) {
			if (a[i] < a[i - 1]) {
				return 0;
			}
		}
		return 1;
	}

}
