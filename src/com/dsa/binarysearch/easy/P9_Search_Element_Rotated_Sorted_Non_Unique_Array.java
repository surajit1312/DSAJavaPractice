/**
 * 
 */
package com.dsa.binarysearch.easy;

/**
 * 
 * You are given a rotated sorted array 'a' of length 'n' and a 'key'. You need
 * to determine if the 'key' exists in the array 'a'. The given sorted array is
 * rotated from an unknown index 'x'.
 * 
 * Such that after rotation the array became [a[x], a[x+1]...., a[n-1], a[1]...,
 * a[x-1]], (0-based indexing). For example, if the array is [1, 2, 3, 4, 5] and
 * x = 2 then the rotated array will be [3, 4, 5, 1, 2, 3].
 * 
 * Return True if the 'key' is found in 'a'. Otherwise, return False.
 * 
 * Note: Array ‘a’ may contain duplicate elements.
 * 
 * Input: a = [6, 10, 1, 3, 5], key = 3
 * 
 * Output: True
 * 
 * Explanation: The array 'a' contains the 'key' = 3, so we return True.
 * 
 * Link:
 * https://www.codingninjas.com/studio/problems/search-in-a-rotated-sorted-array-ii_7449547
 * 
 */
public class P9_Search_Element_Rotated_Sorted_Non_Unique_Array {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr1 = { 6, 10, 1, 3, 5 };
		int target1 = 3;
		boolean output1 = searchInARotatedSortedArrayII(arr1, target1);
		System.out.println("Is " + target1 + " present in array: " + output1);

		int[] arr2 = { 3, 3, 1, 2, 3, 3, 3, 3 };
		int target2 = 1;
		boolean output2 = searchInARotatedSortedArrayII(arr2, target2);
		System.out.println("Is " + target2 + " present in array: " + output2);
	}

	public static boolean searchInARotatedSortedArrayII(int[] A, int key) {
		int low = 0, high = A.length - 1;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (A[mid] == key) {
				return true;
			}
			if (A[low] == A[mid] && A[mid] == A[high]) {
				low = low + 1;
				high = high - 1;
				continue;
			}
			if (A[low] <= A[mid]) {
				if (A[low] <= key && key <= A[mid]) {
					high = mid - 1;
				} else {
					low = mid + 1;
				}
			} else {
				if (A[mid] <= key && key <= A[high]) {
					low = mid + 1;
				} else {
					high = mid - 1;
				}
			}
		}
		return false;
	}

}
