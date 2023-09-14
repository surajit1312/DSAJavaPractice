/**
 * 
 */
package com.dsa.binarysearch.easy;

import java.util.ArrayList;

/**
 * 
 * You have been given a sorted array/list 'arr' consisting of 'n' elements.
 * elements. You are also given an integer 'k'. Now the array is rotated at some
 * pivot point unknown to you.
 * 
 * For example, if 'arr' = [ 1, 3, 5, 7, 8], then after rotating 'arr' at index
 * 3, the array will be 'arr' = [7, 8, 1, 3, 5]. Now, your task is to find the
 * index at which ‘k’ is present in 'arr'.
 * 
 * Notes:
 * 
 * 1. If ‘k’ is not present in 'arr', then print -1. 2. There are no duplicate
 * elements present in 'arr'. 3. 'arr' can be rotated only in the right
 * direction.
 * 
 * Input: 'arr' = [12, 15, 18, 2, 4] , 'k' = 2
 * 
 * Output: 3
 * 
 * Explanation: If 'arr' = [12, 15, 18, 2, 4] and 'k' = 2, then the position at
 * which 'k' is present in the array is 3 (0-indexed).
 * 
 * Link:
 * https://www.codingninjas.com/studio/problems/search-in-rotated-sorted-array_1082554
 */
public class P8_Search_Element_Rotated_Sorted_Unique_Array {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] nums = { 12, 15, 18, 2, 4 };
		int n = 5;
		int target = 2;
		ArrayList<Integer> arr = getArrayList(nums, n);
		int output = search(arr, n, target);
		System.out.println("Index of " + target + " is: " + output);
	}

	private static ArrayList<Integer> getArrayList(int[] a, int n) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		for (int i = 0; i < n; i++) {
			result.add(a[i]);
		}
		return result;
	}

	private static int search(ArrayList<Integer> arr, int n, int k) {
		int low = 0, high = n - 1;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (arr.get(mid) == k) {
				return mid;
			} else if (arr.get(low) <= arr.get(mid)) {
				if (arr.get(low) <= k && k <= arr.get(mid)) {
					high = mid - 1;
				} else {
					low = mid + 1;
				}
			} else {
				if (arr.get(mid) <= k && k <= arr.get(high)) {
					low = mid + 1;
				} else {
					high = mid - 1;
				}
			}
		}
		return -1;
	}

}
