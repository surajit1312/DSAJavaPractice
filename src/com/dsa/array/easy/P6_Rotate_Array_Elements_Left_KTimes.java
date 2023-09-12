/**
 * 
 */
package com.dsa.array.easy;

/**
 * 
 * Given an array 'arr' with 'n' elements, the task is to rotate the array to
 * the left by 'k' steps, where 'k' is non-negative.
 * 
 * Link: https://www.codingninjas.com/studio/problems/rotate-array_1230543
 */
public class P6_Rotate_Array_Elements_Left_KTimes {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] input1 = { 7, 5, 2, 11, 2, 43, 1, 1 };
		int n1 = 8;
		int k1 = 2;
		int[] output1 = rotateArray(input1, n1, k1);
		String printed1 = printArray(output1);
		System.out.println("Rotated array left by " + k1 + " times: " + printed1);

		int[] input2 = { 5, 6, 7, 8 };
		int n2 = 4;
		int k2 = 3;
		int[] output2 = rotateArray(input2, n2, k2);
		String printed2 = printArray(output2);
		System.out.println("Rotated array left by " + k2 + " times: " + printed2);

		int[] input3 = { 1, 3, 6, 11, 12, 17 };
		int n3 = 6;
		int k3 = 4;
		int[] output3 = rotateArray(input3, n3, k3);
		String printed3 = printArray(output3);
		System.out.println("Rotated array left by " + k3 + " times: " + printed3);
	}

	private static String printArray(int[] arr) {
		String result = "";
		for (int i : arr) {
			result = result == "" ? result + i : result + ", " + i;
		}
		return "{ " + result + " }";
	}

	/**
	 * k times left or right direction: left if k > n (size of array) then k = k % n
	 * (at k == n, the array rotates to form initial array order)
	 * 
	 * @param arr
	 * @param n
	 * @param k
	 * @return
	 */
	private static int[] rotateArray(int[] arr, int n, int k) {
		if (arr.length == 0) {
			return new int[0];
		}
		if (k > n) {
			k = k % n;
		}
		int[] temp = new int[k];
		for (int i = 0; i < k; i++) {
			temp[i] = arr[i];
		}
		for (int i = k; i < n; i++) {
			arr[i - k] = arr[i];
		}
		for (int i = 0; i < k; i++) {
			arr[n - k + i] = temp[i];
		}
		return arr;
	}

}
