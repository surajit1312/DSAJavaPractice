/**
 * 
 */
package com.dsa.array.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Coding Ninjas Link: https://www.codingninjas.com/studio/problems/superior-elements_6783446
 * 
 * TC: O(n)
 * SC: O(1)
 */
public class P15_Leaders_In_Array {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] a = { 1, 2, 3, 2 };
		List<Integer> leaders = superiorElements(a);
		System.out.println("Leaders in the given array " + Arrays.toString(a) + " are : " + leaders);
	}

	private static List<Integer> superiorElements(int[] a) {
		List<Integer> leaders = new ArrayList<Integer>();
		int max = a[a.length - 1];
		leaders.add(max);
		for (int i = a.length - 2; i >= 0; i--) {
			if (a[i] > max) {
				leaders.add(a[i]);
				max = a[i];
			}
		}
		return leaders;
	}

}
