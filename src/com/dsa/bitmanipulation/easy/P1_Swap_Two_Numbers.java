/**
 * 
 */
package com.dsa.bitmanipulation.easy;

/**
 * 
 * You are given two numbers 'a' and 'b' as inputs You must swap the values of
 * 'a' and 'b'.
 * 
 * Link: https://www.codingninjas.com/studio/problems/swap-two-numbers_1380853
 */
public class P1_Swap_Two_Numbers {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] a = { 5 };
		int[] b = { 6 };
		System.out.println("Before Swap -> a: " + a[0] + ", b: " + b[0]);
		swapNumber(a, b);
		System.out.println("After Swap -> a: " + a[0] + ", b: " + b[0]);
	}

	private static void swapNumber(int[] a, int[] b) {
		a[0] = a[0] ^ b[0];
		b[0] = a[0] ^ b[0];
		a[0] = a[0] ^ b[0];
	}

}
