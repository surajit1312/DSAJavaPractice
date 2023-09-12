/**
 * 
 */
package com.dsa.array.easy;

/**
 * Given an array 'a' of size 'n' - 1 with elements of range 1 to ‘n’. The array
 * does not contain any duplicates. Your task is to find the missing number.
 * 
 * Link: https://www.codingninjas.com/studio/problems/missing-number_6680467
 */
public class P10_MissingNumber_Array {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] input = { 1, 2, 4, 5 };
		int n = 5;
		int missing = missingNumber(input, n);
		System.out.println("Missing number: " + missing);
	}

	private static int missingNumber(int[] a, int n) {
		int xor1 = 0, xor2 = 0;
		for (int i = 1; i < n; i++) {
			xor1 = xor1 ^ a[i - 1];
			xor2 = xor2 ^ i;
		}
		xor2 = xor2 ^ n;
		return xor1 ^ xor2;
	}

}
