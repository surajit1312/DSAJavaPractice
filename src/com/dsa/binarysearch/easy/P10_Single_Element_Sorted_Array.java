/**
 * 
 */
package com.dsa.binarysearch.easy;

import java.util.ArrayList;

/**
 * 
 * You are given a sorted array 'arr' of 'n' numbers such that every number
 * occurred twice in the array except one, which appears only once. Return the
 * number that appears once.
 * 
 * Example:
 * 
 * Input: 'arr' = [1,1,2,2,4,5,5]
 * 
 * Output: 4
 * 
 * Explanation: Number 4 only appears once the array.
 * 
 * Note: Exactly one number in the array 'arr' appears once.
 * 
 * Link:
 * https://www.codingninjas.com/studio/problems/unique-element-in-sorted-array_1112654
 * 
 */
public class P10_Single_Element_Sorted_Array {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] a = { 1, 1, 2, 2, 4, 5, 5 };
		ArrayList<Integer> arr = getArrayList(a, a.length);
		int ans = singleNonDuplicate(arr);
		System.out.println("Single Element in a sorted array is: " + ans);

		int[] b = { 1, 1, 4, 4, 15 };
		ArrayList<Integer> brr = getArrayList(b, b.length);
		int res = singleNonDuplicate(brr);
		System.out.println("Single Element in a sorted array is: " + res);
	}

	private static ArrayList<Integer> getArrayList(int[] a, int n) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		for (int i = 0; i < n; i++) {
			result.add(a[i]);
		}
		return result;
	}

	private static int singleNonDuplicate(ArrayList<Integer> arr) {
		// Corner cases
		if (arr.size() == 1) {
			return arr.get(0);
		}
		if (arr.get(0) != arr.get(1)) {
			return arr.get(0);
		}
		int n = arr.size();
		if (arr.get(n - 2) != arr.get(n - 1)) {
			return arr.get(n - 1);
		}

		int low = 1, high = n - 2;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (arr.get(mid) != arr.get(mid - 1) && arr.get(mid) != arr.get(mid + 1)) {
				return arr.get(mid);
			} else {
				if ((mid % 2 == 1 && (arr.get(mid - 1) == arr.get(mid)))
						|| (mid % 2 == 0) && (arr.get(mid + 1) == arr.get(mid))) {
					low = mid + 1;
				} else {
					high = mid - 1;
				}
			}
		}
		return -1;
	}

}
