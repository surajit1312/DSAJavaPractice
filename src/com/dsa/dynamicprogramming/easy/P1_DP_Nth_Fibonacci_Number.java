/**
 * 
 */
package com.dsa.dynamicprogramming.easy;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Coding Ninjas Link:
 * https://www.codingninjas.com/studio/problems/nth-fibonacci-number_74156 
 * 
 * TC: O(n) - reduced to O(n) due to memoization 
 * SC: O(n) - used an array of size n + 1
 */
public class P1_DP_Nth_Fibonacci_Number {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("Input term");
			int n = sc.nextInt();
			int[] dpArr = new int[n + 1];
			Arrays.fill(dpArr, -1);
			int fiboN = getFibonacciNthTerm(n, dpArr);
			System.out.println("Fibonacci series " + n + "th term (using recursive memoization) is : " + fiboN);
			int fiboNIter = getFibonacciNthTermIteration(n, dpArr);
			System.out.println("Fibonacci series " + n + "th term (using tabulation iteration) is : " + fiboNIter);
			int fiboNBest = getFibonacciBestApproach(n);
			System.out.println("Fibonacci series " + n + "th term (using two pointers approach) is : " + fiboNBest);
		}
	}

	/**
	 * 
	 * TC: O(n) - reduced to O(n) due to memoization 
	 * SC: O(n) - used an array of size n + 1
	 * 
	 * @param n
	 * @param dpArr
	 * @return
	 */
	private static int getFibonacciNthTerm(int n, int[] dpArr) {
		if (n == 0 || n == 1) {
			return n;
		}
		if (dpArr[n] != -1) {
			return dpArr[n];
		} else {
			dpArr[n] = getFibonacciNthTerm(n - 1, dpArr) + getFibonacciNthTerm(n - 2, dpArr);
			return dpArr[n];
		}
	}

	/**
	 * TC: O(n) - reduced to O(n) due to iteration/tabulation 
	 * SC: O(n) - used an array of size n + 1, reduced recursive stack space
	 * 
	 * @param n
	 * @param dpArr
	 * @return
	 */
	private static int getFibonacciNthTermIteration(int n, int[] dpArr) {
		dpArr[0] = 0;
		dpArr[1] = 1;
		for (int i = 2; i <= n; i++) {
			dpArr[i] = dpArr[i - 1] + dpArr[i - 2];
		}
		return dpArr[n];
	}

	/**
	 * TC: O(n) - reduced to O(n) 
	 * SC: O(1) - removed usage of dpArr
	 * 
	 * @param n
	 * @return
	 */
	private static int getFibonacciBestApproach(int n) {
		int fibo2Prev = 0, fibo1Prev = 1;
		for (int i = 2; i <= n; i++) {
			int current = fibo2Prev + fibo1Prev;
			fibo2Prev = fibo1Prev;
			fibo1Prev = current;
		}
		return fibo1Prev;
	}

}
