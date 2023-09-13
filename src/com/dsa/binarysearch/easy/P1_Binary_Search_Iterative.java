/**
 * 
 */
package com.dsa.binarysearch.easy;

/**
 * 
 * Input: ‘N’ = 7 ‘target’ = 3 ‘A’ = [1, 3, 7, 9, 11, 12, 45]
 * 
 * Output: 1
 * 
 * Explanation: For A = [1, 3, 7, 9, 11, 12, 45], The index of element '3' is 1.
 * Hence, the answer is '1'.
 * 
 * Link: https://www.codingninjas.com/studio/problems/binary-search_972
 * 
 */
public class P1_Binary_Search_Iterative {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] input1 = { 1, 3, 7, 9, 11, 12, 45 };
		int target1 = 3;
		int output1 = search(input1, target1);
		System.out.println("The index of element " + target1 + " is: " + output1);
	}

	private static int search(int[] nums, int target) {
		int low = 0, high = nums.length - 1;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (nums[mid] == target) {
				return mid;
			} else if (nums[mid] < target) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		return -1;
	}
}
