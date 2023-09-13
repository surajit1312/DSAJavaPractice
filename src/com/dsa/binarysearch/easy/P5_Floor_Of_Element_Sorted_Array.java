/**
 * 
 */
package com.dsa.binarysearch.easy;

/**
 * 
 * You are given a sorted array ‘A’ and an integer ‘X’. Your task is to find and
 * return the floor value of ‘X’ in the array. The floor value of ‘X’ in array
 * ‘A’ is the largest element in the array which is smaller than or equal to X.
 * Note: In case there is no floor value of ’X’ in the array ‘A’, return -1.
 * 
 * For the given arr[ ] = { 1, 2, 5, 7, 8, 9, 12, 14 } and X = 10
 * 
 * The floor of 10 is 7 because 7 is the largest element in the array which is
 * smaller than 10.
 * 
 * Link: https://www.codingninjas.com/studio/problems/find-floor-value_920447
 * 
 * TC: O(log2 N)
 */
public class P5_Floor_Of_Element_Sorted_Array {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] input = { 1, 2, 5, 7, 12, 14 };
		int target = 10;
		int n = 6;
		int output = floorSearch(input, target, n);
		System.out.println("The floor value of element " + target + " is: " + output);
	}

	public static int floorSearch(int[] arr, int X, int N) {
		int low = 0, high = N - 1, ans = -1;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (arr[mid] <= X) {
				ans = arr[mid];
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		return ans;
	}

}
