/**
 * 
 */
package com.dsa.recursion.hard;

/**
 * 
 * CodingNinjas
 * 
 * Link:
 * 
 * https://www.codingninjas.com/studio/problems/implement-atoi-function_981270
 * 
 * TC: O(n)
 * SC: O(1)
 * 
 */
public class P1_Implement_atoi_Functionality {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String s = " +9743764253581200415067431L";
		int result = atoi(s);
		System.out.println(result);
	}

	private static int atoi(String str) {
		if (str == null) {
			return 0;
		}
		str = str.trim();
		if (str.length() == 0) {
			return 0;
		}
		long result = 0;
		int sign = 1;
		int MIN = Integer.MIN_VALUE;
		int MAX = Integer.MAX_VALUE;
		boolean signFound = str.charAt(0) == '+' || str.charAt(0) == '-';

		int index = signFound ? 1 : 0;

		if (str.charAt(0) == '-') {
			sign = -1;
		}
		while (index < str.length()) {
			if (str.charAt(index) == ' ' || !Character.isDigit(str.charAt(index))) {
				break;
			}
			result = result * 10 + str.charAt(index) - '0';
			if (sign == -1 && (result * sign) < MIN) {
				return MIN;
			}
			if (sign == 1 && (result * sign) > MAX) {
				return MAX;
			}
			index++;
		}
		result = result * sign;

		return (int) result;
	}

}
