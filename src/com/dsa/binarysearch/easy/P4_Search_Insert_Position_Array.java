/**
 * 
 */
package com.dsa.binarysearch.easy;

/**
 * 
 * You are given a sorted array 'arr' of distinct values and a target value 'm'.
 * You need to search for the index of the target value in the array. If the
 * value is present in the array, return its index. If the value is absent,
 * determine the index where it would be inserted in the array while maintaining
 * the sorted order.
 * 
 * Input: arr = [1, 2, 4, 7], m = 6
 * 
 * Output: 3
 * 
 * Explanation:
 * 
 * If the given array 'arr' is: [1, 2, 4, 7] and m = 6. We insert m = 6 in the
 * array and get 'arr' as: [1, 2, 4, 6, 7]. The position of 6 is 3 (according to
 * 0-based indexing)
 * 
 * Link:
 * https://www.codingninjas.com/studio/problems/algorithm-to-find-best-insert-position-in-sorted-array_839813
 * 
 * TC: O(log2 N)
 * 
 */
public class P4_Search_Insert_Position_Array {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] input = { 1, 2, 4, 7 };
		int target = 6;
		int output = searchInsert(input, target);
		System.out.println("The position of element " + target + " is: " + output);
	}

	private static int searchInsert(int[] arr, int m) {
		int low = 0, high = arr.length - 1, ans = arr.length;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (arr[mid] >= m) {
				ans = mid;
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return ans;
	}

}
