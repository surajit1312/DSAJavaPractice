/**
 * 
 */
package com.dsa.recursion.easy;

import java.util.Scanner;

/**
 * 
 * CodingNinjas: Factorial of a Number
 * 
 * Link:
 * 
 * https://www.codingninjas.com/studio/problems/factorial-of-a-number_1115779
 * 
 * TC: O(n)
 * SC: O(n) - Arbitrary space used for recursion stack
 * 
 */
public class P1_Factorial_of_Number {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		if (n < 0) {
			System.out.println("Error");
		} else {
			int factorial = fact(n);
			System.out.println(factorial);
		}
		scanner.close();
	}

	private static int fact(int n) {
		if (n == 0 || n == 1) {
			return 1;
		}
		return n * fact(n - 1);
	}

}
