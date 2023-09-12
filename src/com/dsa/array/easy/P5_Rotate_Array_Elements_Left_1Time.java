/**
 * 
 */
package com.dsa.array.easy;

/**
 * Rotating the array left by one means shifting all elements by one place to
 * the left and moving the first element to the last position in the array.
 * 
 * Link:
 * https://www.codingninjas.com/studio/problems/left-rotate-an-array-by-one_5026278
 */
public class P5_Rotate_Array_Elements_Left_1Time {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] input1 = { 1, 2, 3, 4, 5 };
		int n1 = 5;
		int[] output1 = rotateArray(input1, n1);
		String printed1 = printArray(output1);
		System.out.println("Rotated array left by 1 time: " + printed1);
	}

	private static String printArray(int[] arr) {
		String result = "";
		for (int i : arr) {
			result = result == "" ? result + i : result + ", " + i;
		}
		return "{ " + result + " }";
	}

	private static int[] rotateArray(int[] arr, int n) {
		if (arr.length == 0) {
			return new int[0];
		}
		int temp = arr[0];
		for (int i = 1; i < n; i++) {
			arr[i - 1] = arr[i];
		}
		arr[n - 1] = temp;
		return arr;
	}

}
