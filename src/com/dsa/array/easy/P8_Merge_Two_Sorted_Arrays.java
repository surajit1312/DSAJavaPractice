/**
 * 
 */
package com.dsa.array.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Given two sorted arrays, a and b, of size m and n respectively, return the
 * union of the arrays. Link:
 * https://www.codingninjas.com/studio/problems/sorted-array_6613259
 * 
 * TC: O(m + n), SC: O(n)
 */
public class P8_Merge_Two_Sorted_Arrays {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] a = { 1, 2, 2, 3, 3, 4, 5, 6 };
		int[] b = { 2, 3, 3, 5, 6, 6, 7 };
		List<Integer> list = sortedArray(a, b);
		String output = printList(list);
		System.out.println("Merged array: " + output);

		int[] m = { 3, 3, 4, 5, 6, 7, 8, 9, 9, 9 };
		int[] n = { 2, 4, 10, 10 };
		List<Integer> merge = sortedArray(m, n);
		String merged = printList(merge);
		System.out.println("Merged array: " + merged);
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
		int last = -1;
		List<Integer> list = new ArrayList<Integer>();
		while (p < n1 && q < n2) {
			if (a[p] <= b[q]) {
				if (a[p] != last) {
					list.add(a[p]);
					last = a[p];
				}
				p++;
			} else {
				if (b[q] != last) {
					list.add(b[q]);
					last = b[q];
				}
				q++;
			}
		}
		while (p < n1) {
			if (a[p] != last) {
				list.add(a[p]);
				last = a[p];
			}
			p++;
		}
		while (q < n2) {
			if (b[q] != last) {
				list.add(b[q]);
				last = b[q];
			}
			q++;
		}
		return list;
	}

}
