/**
 * 
 */
package com.dsa.hashing.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 */
public class P1_Count_Frequency_In_Range {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int n = 6;
		int x = 4;
		int[] nums = { 1, 3, 4, 3, 4, 1 };
		int[] frequency = countFrequency(n, x, nums);
		System.out.println("Frequency of numbers in " + Arrays.toString(nums) + " is : " + Arrays.toString(frequency));
	}

	public static int[] countFrequency(int n, int x, int[] nums) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			if (!map.containsKey(nums[i])) {
				map.put(nums[i], 1);
			} else {
				map.put(nums[i], map.get(nums[i]) + 1);
			}
		}
		int[] result = new int[n];
		for (int i = 0; i < n; i++) {
			result[i] = map.containsKey(i + 1) ? map.get(i + 1) : 0;
		}
		return result;
	}

}
