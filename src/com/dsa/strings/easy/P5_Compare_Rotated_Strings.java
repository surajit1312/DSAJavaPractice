/**
 * 
 */
package com.dsa.strings.easy;

/**
 * CodingNinjas Link: https://www.codingninjas.com/studio/problems/check-if-one-string-is-a-rotation-of-another-string_1115683
 * 
 * TC: O(n)
 * SC: O(1)
 * 
 */
public class P5_Compare_Rotated_Strings {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String p = "abac";
		String q = "baca";
		int result = isCyclicRotation(p, q);
		System.out.println("String " + p + " is rotation of String " + q + " : " + result);
	}

	public static int isCyclicRotation(String p, String q) {
		if (p.length() != q.length()) {
			return 0;
		}
		if (p.equals(q)) {
			return 1;
		}
		p = p + p;
		return p.contains(q) ? 1 : 0;
	}

}
