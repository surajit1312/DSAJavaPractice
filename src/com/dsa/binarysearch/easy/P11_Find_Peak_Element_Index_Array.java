/**
 * 
 */
package com.dsa.binarysearch.easy;

import java.util.ArrayList;

/**
 * 
 * You are given an array 'arr' of length 'n'. Find the index(0-based) of a peak
 * element in the array. If there are multiple peak numbers, return the index of
 * any peak number. Peak element is defined as that element that is greater than
 * both of its neighbors. If 'arr[i]' is the peak element, 'arr[i - 1]' <
 * 'arr[i]' and 'arr[i + 1]' < 'arr[i]'.
 * 
 * Assume 'arr[-1]' and 'arr[n]' as negative infinity.
 * 
 * 1. There are no 2 adjacent elements having same value (as mentioned in the
 * constraints). 2. Do not print anything, just return the index of the peak
 * element (0 - indexed). 3. 'True'/'False' will be printed depending on whether
 * your answer is correct or not.
 * 
 * Input: 'arr' = [1, 8, 1, 5, 3]
 * 
 * Output: 3
 * 
 * Explanation: There are two possible answers. Both 8 and 5 are peak elements,
 * so the correct answers are their positions, 1 and 3.
 * 
 * Link: https://www.codingninjas.com/studio/problems/find-peak-element_1081482
 * 
 * 
 */
public class P11_Find_Peak_Element_Index_Array {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] a = { 1, 8, 1, 5, 3 };
		ArrayList<Integer> arr = getArrayList(a, a.length);
		int ans = findPeakElement(arr);
		System.out.println("Peak Element in a sorted array is: " + ans);

		int[] b = { 1, 2, 1 };
		ArrayList<Integer> brr = getArrayList(b, b.length);
		int res = findPeakElement(brr);
		System.out.println("Peak Element in a sorted array is: " + res);
	}

	private static ArrayList<Integer> getArrayList(int[] a, int n) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		for (int i = 0; i < n; i++) {
			result.add(a[i]);
		}
		return result;
	}

	private static int findPeakElement(ArrayList<Integer> arr) {
		// Corner cases
		int n = arr.size();
		if (n == 1) {
			return 0;
		}
		if (arr.get(0) > arr.get(1)) {
			return 0;
		}
		if (arr.get(n - 1) > arr.get(n - 2)) {
			return n - 1;
		}
		int low = 1, high = n - 2;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (arr.get(mid) > arr.get(mid - 1) && arr.get(mid) > arr.get(mid + 1)) {
				return mid;
			} else if (arr.get(mid) > arr.get(mid - 1)) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		return -1;
	}

}
