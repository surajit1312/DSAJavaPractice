/**
 * 
 */
package com.dsa.binarysearch.easy;

import java.util.ArrayList;

/**
 * 
 * You have been given a sorted array/list 'arr' consisting of 'n' elements. You
 * are also given an integer 'k'. Now, your task is to find the first and last
 * occurrence of ‘k’ in 'arr'.
 * 
 * Notes:
 * 
 * 1. If ‘k’ is not present in the array, then the first and the last occurrence
 * will be -1.
 * 
 * 2. 'arr' may contain duplicate elements.
 * 
 * Input: 'arr' = [0,1,1,5] , 'k' = 1
 * 
 * Output: 1 2
 * 
 * Explanation: If 'arr' = [0, 1, 1, 5] and 'k' = 1, then the first and last
 * occurrence of 1 will be 1(0 - indexed) and 2.
 * 
 * Link:
 * https://www.codingninjas.com/studio/problems/first-and-last-position-of-an-element-in-sorted-array_1082549
 * 
 * TC: O(2log2 N) ~ O(log2 N)
 * 
 */
public class P6_Find_First_Last_Occurence_Array {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] nums1 = { 1, 3, 3, 5 };
		int n1 = 4;
		int target1 = 2;
		ArrayList<Integer> arr1 = getArrayList(nums1, n1);
		int[] output1 = firstAndLastPosition(arr1, n1, target1);
		System.out.println("First and Last occurence of " + target1 + " is : " + output1[0] + " and " + output1[1]);

		int[] nums2 = { 0, 0, 1, 1, 2, 2, 2, 2 };
		int n2 = 8;
		int target2 = 2;
		ArrayList<Integer> arr2 = getArrayList(nums2, n2);
		int[] output2 = firstAndLastPosition(arr2, n2, target2);
		System.out.println("First and Last occurence of " + target2 + " is : " + output2[0] + " and " + output2[1]);
	}

	private static ArrayList<Integer> getArrayList(int[] a, int n) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		for (int i = 0; i < n; i++) {
			result.add(a[i]);
		}
		return result;
	}

	private static int[] firstAndLastPosition(ArrayList<Integer> arr, int n, int k) {
		int[] ans = new int[2];
		int l = 0, h = n - 1, first = -1, last = -1;
		while (l <= h) {
			int mid = l + (h - l) / 2;
			if (arr.get(mid) == k) {
				first = mid;
				h = mid - 1;
			} else if (arr.get(mid) > k) {
				h = mid - 1;
			} else {
				l = mid + 1;
			}
		}
		ans[0] = first;
		if (first == -1) {
			last = -1;
		} else {
			int l1 = first, h1 = n - 1;
			while (l1 <= h1) {
				int mid = l1 + (h1 - l1) / 2;
				if (arr.get(mid) == k) {
					last = mid;
					l1 = mid + 1;
				} else if (arr.get(mid) > k) {
					h1 = mid - 1;
				} else {
					l1 = mid + 1;
				}
			}
		}
		ans[1] = last;
		return ans;
	}

}
