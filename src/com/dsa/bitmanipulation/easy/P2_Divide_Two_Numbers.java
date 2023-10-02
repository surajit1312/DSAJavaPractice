/**
 * 
 */
package com.dsa.bitmanipulation.easy;

/**
 * 
 * You are given two integers, 'dividend' and 'divisor'. You are required to
 * divide the integers without using multiplication, division, and modular
 * operators. Your task is to return the quotient after dividing ‘dividend’ by
 * ‘divisor’.
 * 
 * In cases where the dividend is not perfectly divisible by the divisor, you
 * are required to return the integer value of the quotient which is closer to
 * zero.
 * 
 * For example - If the answer is '8.34', we return the integer part, i.e., '8'.
 * Also, If the answer is '-2.67', we return the integer part, i.e., '-2'.
 * 
 * Assume we're dealing with a system that can only store integers in the 32-bit
 * signed integer range: [2^31, 2^31-1]. If the quotient is higher than 2^31 -
 * 1, return 2^31 - 1; if it is less than -2^31, return -2^31.
 *
 * Link: https://www.codingninjas.com/studio/problems/-divide-two-integers_1112617
 * 
 */
public class P2_Divide_Two_Numbers {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int ans = divideTwoInteger(7, -3);
		System.out.println("Division of 7 and -3 is: " + ans);
	}

	private static int divideTwoInteger(int dividend, int divisor) {
		int sign = (dividend < 0) ^ (divisor < 0) ? -1 : 1;
		int quotient = 0;
		dividend = Math.abs(dividend);
		divisor = Math.abs(divisor);
		if (divisor == 1) {
			quotient = dividend;
		} else {
			while (dividend > divisor) {
				dividend -= divisor;
				quotient++;
			}
		}
		quotient *= sign;
		return quotient;
	}

}
