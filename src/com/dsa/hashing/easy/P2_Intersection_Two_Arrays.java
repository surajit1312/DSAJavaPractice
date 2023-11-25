/**
 * 
 */
package com.dsa.hashing.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

/**
 * Leetcode 349. Intersection of Two Arrays
 * 
 * Link: https://leetcode.com/problems/intersection-of-two-arrays/description/
 * 
 * TC: O(1)
 * SC: O(n) where n and m are lengths of two arrays where n < m
 * 
 */
public class P2_Intersection_Two_Arrays {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] nums1 = { 4, 9, 5 }, nums2 = { 9, 4, 9, 8, 4 };
		int[] common = intersection(nums1, nums2);
		System.out.println("Intersection of " + Arrays.toString(nums1) + " and " + Arrays.toString(nums2)
				+ " is(are) : " + Arrays.toString(common));
	}

	private static int[] intersection(int[] nums1, int[] nums2) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		HashSet<Integer> set = new HashSet<Integer>();
		for (Integer it : nums1) {
			set.add(it);
		}
		for (Integer it : nums2) {
			if (set.contains(it)) {
				list.add(it);
				set.remove(it);
			}
		}
		int[] common = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			common[i] = list.get(i);
		}
		return common;
	}

}
