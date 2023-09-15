/**
 * 
 */
package com.dsa.array.easy;

/**
 * 
 * Link: https://www.codingninjas.com/studio/problems/sum-of-max-and-min_1081476
 */
public class P12_Sum_Max_Min_Array {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr = {-1, -4, 5, 8, 9, 3};
		int n = 6;
		int sumMaxMin = sumOfMaxMin(arr, n);
		System.out.println("Sum of max and min in array: " + sumMaxMin);
	}

	public static int sumOfMaxMin(int[] arr, int n) {
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < n; i++) {
			if (arr[i] > max) {
				max = arr[i];
			}
			if (arr[i] < min) {
				min = arr[i];
			}
		}
		return max + min;
	}

}
