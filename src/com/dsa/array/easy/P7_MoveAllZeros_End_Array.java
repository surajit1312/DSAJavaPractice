/**
 * 
 */
package com.dsa.array.easy;

/**
 * Given an array 'arr' of 'n' non-negative integers, your task is to move all
 * the zeros to the end of the array while keeping the non-zero elements at the
 * start of the array in their original order. Return the modified array.
 * 
 * Link:
 * https://www.codingninjas.com/studio/problems/ninja-and-the-zero-s_6581958
 */
public class P7_MoveAllZeros_End_Array {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int n1 = 6;
		int[] input1 = { 1, 2, 0, 0, 2, 3 };
		int[] output1 = moveZeros(n1, input1);
		String printed1 = printArray(output1);
		System.out.println("Array after moving all zeros to end: " + printed1);
	}

	private static String printArray(int[] arr) {
		String result = "";
		for (int i : arr) {
			result = result == "" ? result + i : result + ", " + i;
		}
		return "{ " + result + " }";
	}

	private static int[] moveZeros(int n, int[] a) {
		int p = -1;
		for (int i = 0; i < n; i++) {
			if (a[i] == 0) {
				p = i;
				break;
			}
		}
		if (p == -1) {
			return a;
		}
		for (int i = p + 1; i < n; i++) {
			if (a[i] != 0) {
				swap(a, i, p);
				p++;
			}
		}
		return a;
	}

	private static void swap(int[] arr, int i, int p) {
		int temp = arr[i];
		arr[i] = arr[p];
		arr[p] = temp;
	}

}
