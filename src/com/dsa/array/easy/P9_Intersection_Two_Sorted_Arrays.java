/**
 * 
 */
package com.dsa.array.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * You are given two arrays 'A' and 'B' of size 'N' and 'M' respectively. Both
 * these arrays are sorted in non-decreasing order. You have to find the
 * intersection of these two arrays.
 * 
 * Intersection of two arrays is an array that consists of all the common
 * elements occurring in both arrays.
 * 
 * Link:
 * https://www.codingninjas.com/studio/problems/intersection-of-2-arrays_1082149
 * TC: O (n + m) SC: O(1)
 */
public class P9_Intersection_Two_Sorted_Arrays {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] a = { 1, 2, 2, 3, 3, 4, 5, 6 };
		int[] b = { 2, 3, 3, 5, 6, 6, 7 };
		List<Integer> list = sortedArray(a, b);
		String output = printList(list);
		System.out.println("Merged array: " + output);

		int[] m = { 1, 4, 5 };
		int[] n = { 3, 4, 5 };
		List<Integer> intersect = sortedArray(m, n);
		String intersected = printList(intersect);
		System.out.println("Merged array: " + intersected);
	}

	private static String printList(List<Integer> list) {
		String result = "";
		for (int i : list) {
			result = result == "" ? result + i : result + ", " + i;
		}
		return "{ " + result + " }";
	}

	public static List<Integer> sortedArray(int[] a, int[] b) {
		int n1 = a.length, n2 = b.length;
		int p = 0, q = 0;
		List<Integer> list = new ArrayList<Integer>();

		while (p < n1 && q < n2) {
			if (a[p] > b[q]) {
				q++;
			} else if (a[p] < b[q]) {
				p++;
			} else {
				list.add(a[p]);
				p++;
				q++;
			}
		}
		return list;
	}

}
