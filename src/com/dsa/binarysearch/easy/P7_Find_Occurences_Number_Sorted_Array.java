/**
 * 
 */
package com.dsa.binarysearch.easy;

/**
 * 
 * You have been given a sorted array/list of integers 'arr' of size 'n' and an
 * integer 'x' Find the total number of occurrences of 'x' in the array/list.
 * 
 * Input: 'n' = 7, 'x' = 3 'arr' = [1, 1, 1, 2, 2, 3, 3]
 * 
 * Output: 2
 * 
 * Explanation: Total occurrences of '3' in the array 'arr' is 2.
 * 
 * Link:
 * https://www.codingninjas.com/studio/problems/occurrence-of-x-in-a-sorted-array_630456
 * 
 */
public class P7_Find_Occurences_Number_Sorted_Array {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] nums1 = { 1, 1, 1, 2, 2, 3, 3 };
		int n1 = 7;
		int target1 = 3;
		int output1 = count(nums1, n1, target1);
		System.out.println("Count of occurences of " + target1 + " is : " + output1);

		int[] nums2 = { 0, 0, 1, 1, 2, 2, 2, 2 };
		int n2 = 8;
		int target2 = 2;
		int output2 = count(nums2, n2, target2);
		System.out.println("Count of occurences of " + target2 + " is : " + output2);
	}

	public static int count(int arr[], int n, int x) {
		int first = getFirstOccurenceIndex(arr, n, x);
		int last = getLastOccurenceIndex(arr, n, x);
		if (first == -1) {
			return 0;
		} else {
			return last - first + 1;
		}
	}

	private static int getFirstOccurenceIndex(int arr[], int n, int x) {
		int low = 0, high = n - 1, ans = -1;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (arr[mid] == x) {
				ans = mid;
				high = mid - 1;
			} else if (arr[mid] > x) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return ans;
	}

	private static int getLastOccurenceIndex(int arr[], int n, int x) {
		int low = 0, high = n - 1, ans = -1;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (arr[mid] == x) {
				ans = mid;
				low = mid + 1;
			} else if (arr[mid] > x) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return ans;
	}

}
