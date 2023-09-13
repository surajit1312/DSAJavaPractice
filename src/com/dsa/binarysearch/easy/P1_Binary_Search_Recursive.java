/**
 * 
 */
package com.dsa.binarysearch.easy;

/**
 * 
 * 
 * For nums = [1, 2, 3, 4, 5, 6, 7], Element '9' doesn't exist. Hence, the
 * answer is '-1'.
 * 
 * Link: https://www.codingninjas.com/studio/problems/binary-search_972
 * 
 * TC: O(log2 N)
 */
public class P1_Binary_Search_Recursive {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] input1 = { 1, 2, 3, 4, 5, 6, 7 };
		int target1 = 9;
		int output1 = search(input1, 0, input1.length - 1, target1);
		System.out.println("The index of element " + target1 + " is: " + output1);
	}

	private static int search(int[] nums, int low, int high, int target) {
		// Base case
		if (low > high) {
			return -1;
		}
		int mid = low + (high - low) / 2;
		if (nums[mid] == target) {
			return mid;
		} else if (nums[mid] < target) {
			return search(nums, mid + 1, high, target);
		} else {
			return search(nums, low, mid - 1, target);
		}
	}

}
