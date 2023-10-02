/**
 * 
 */
package com.dsa.bitmanipulation.easy;

/**
 * 
 * You are given an integer N.
 * Return 'odd' if the given number 'N' is odd, else return 'even'.
 * 
 * Link: https://www.codingninjas.com/studio/problems/odd-even_7993579
 */
public class P3_Check_Odd_Even_Number {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Is 4 even/odd : " + oddEven(4));
		System.out.println("Is 7 even/odd : " + oddEven(7));
	}

	private static String oddEven(int N) {
		return (N ^ 1) == (N + 1) ? "even" : "odd";
	}

}
