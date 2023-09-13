/**
 * 
 */
package com.dsa.binarysearch.easy;

/**
 * 
 * For a sorted array 'arr', 'lower_bound' of a number 'x' is defined as the
 * smallest index 'idx' such that the value 'arr[idx]' is not less than 'x'
 * 
 * If all numbers are smaller than 'x', then 'n' should be the 'lower_bound' of
 * 'x', where 'n' is the size of array.
 * 
 * Consider 0-based indexing.
 * 
 * Input: ‘arr’ = [1, 2, 2, 3] and 'x' = 0
 * 
 * Output: 0
 * 
 * Explanation: Index '0' is the smallest index such that 'arr[0]' is not less
 * than 'x'.
 * 
 * Link: https://www.codingninjas.com/studio/problems/lower-bound_8165382
 * 
 * TC: O(log2 N)
 */
public class P2_Get_Lower_Bound_Number {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] input = { 1, 2, 2, 3 };
		int n = 4;
		int target = 0;
		int output = lowerBound(input, n, target);
		System.out.println("The lower bound of element " + target + " is: " + output);
	}

	private static int lowerBound(int[] arr, int n, int x) {
		int low = 0, high = n - 1, ans = n;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (arr[mid] >= x) {
				ans = mid;
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return ans;
	}

}
