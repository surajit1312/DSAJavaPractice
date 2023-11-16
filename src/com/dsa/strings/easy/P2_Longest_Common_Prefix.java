/**
 * 
 */
package com.dsa.strings.easy;

import java.util.Arrays;

/**
 * 
 * CodingNinjas Link: https://www.codingninjas.com/studio/problems/longest-common-prefix_628874
 * 
 * TC: O(n)
 * SC: O(1)
 */
public class P2_Longest_Common_Prefix {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String[] input = { "Codingninjas", "Coding", "Coders", "Codezen" };
		String prefix = commonPrefix(input, input.length);
		System.out.println("Longest prefix in " + Arrays.toString(input) + " is : " + prefix);
	}

	public static String commonPrefix(String[] arr, int n) {
		if (arr == null || arr.length == 0) {
			return "-1";
		}
		Arrays.sort(arr);
		String a = arr[0];
		String b = arr[n - 1];
		String prefix = "";
		for (int i = 0; i < a.length(); i++) {
			if (a.charAt(i) == b.charAt(i)) {
				prefix += a.charAt(i);
			} else {
				break;
			}
		}
		prefix = prefix == "" ? "-1" : prefix;
		return prefix;
	}

}
