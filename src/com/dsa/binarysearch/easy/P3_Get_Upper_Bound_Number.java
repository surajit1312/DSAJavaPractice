/**
 * 
 */
package com.dsa.binarysearch.easy;

/**
 * 
 * The upper bound in a sorted array is the index of the first value that is
 * greater than a given value. If the greater value does not exist then the
 * answer is 'n', Where 'n' is the size of the array. We are using 0-based
 * indexing. Try to write a solution that runs in log(n) time complexity.
 * 
 * 
 * Input : ‘arr’ = {2,4,6,7} and ‘x’ = 5,
 * 
 * Output: 2
 * 
 * Explanation: The upper bound of 5 is 6 in the given array, which is at index
 * 2 (0-indexed).
 * 
 * Link:
 * https://www.codingninjas.com/studio/problems/implement-upper-bound_8165383
 * 
 * TC: O(log2 N)
 * 
 */
public class P3_Get_Upper_Bound_Number {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] input = { 2, 4, 6, 7 };
		int n = 4;
		int target = 5;
		int output = upperBound(input, target, n);
		System.out.println("The upper bound of element " + target + " is: " + output);
	}

	public static int upperBound(int[] arr, int x, int n) {
		int low = 0, high = n - 1, ans = n;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (arr[mid] > x) {
				ans = mid;
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return ans;
	}

}
