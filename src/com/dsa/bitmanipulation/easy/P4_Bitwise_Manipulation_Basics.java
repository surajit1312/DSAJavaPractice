/**
 * 
 */
package com.dsa.bitmanipulation.easy;

/**
 * 
 * CodingNinjas
 * 
 * Link:
 * 
 * https://www.codingninjas.com/studio/problems/bitwise-basic-operations_8382552
 * 
 */
public class P4_Bitwise_Manipulation_Basics {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int a = 1, b = 2, c = 1, d = 3, e = 2, f = 3;
		int xor = getXOR(a, b);
		int bit = getBit(c, d);
		int set = setBit(e, f);

		System.out.println("XOR operation : " + xor);
		System.out.println("Get BIT operation : " + bit);
		System.out.println("Set BIT operation : " + set);
	}

	private static int getXOR(int a, int b) {
		return a ^ b;
	}

	private static int getBit(int c, int d) {
		return d >> c & 1;
	}

	private static int setBit(int e, int f) {
		int bit = f >> e & 1;
		if (bit == 0) {
			f = f | 1 << e;
		}
		return f;
	}

}
