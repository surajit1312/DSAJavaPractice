/**
 * 
 */
package com.dsa.array.easy;

/**
 * 
 * Get second order maximum and minimum elements in an array
 * Link: https://www.codingninjas.com/studio/problems/ninja-and-the-second-order-elements_6581960
 * 
 */
public class P2_Second_LargestSmallest_Element {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int n = 5;

		int[] input1 = { 1, 2, 3, 4, 5 };
		int[] secondOrderElements1 = getSecondOrderElements(n, input1);
		System.out.println("Second order elements in array are: { " + secondOrderElements1[0] + ", "
				+ secondOrderElements1[1] + " }");

		int[] input2 = { 9, 6, 4, 1, 2 };
		int[] secondOrderElements2 = getSecondOrderElements(n, input2);
		System.out.println("Second order elements in array are: { " + secondOrderElements2[0] + ", "
				+ secondOrderElements2[1] + " }");
	}

	private static int[] getSecondOrderElements(int n, int[] arr) {
		int[] result = new int[2];
		int max = -1, secondMax = -1;
		int min = Integer.MAX_VALUE, secondMin = Integer.MAX_VALUE;
		for (int i = 0; i < n; i++) {
			// finding max
			if (arr[i] > max) {
				secondMax = max;
				max = arr[i];
			} else if (arr[i] < max) {
				if (secondMax == -1 || secondMax < arr[i]) {
					secondMax = arr[i];
				}
			}
			// finding min
			if (arr[i] < min) {
				secondMin = min;
				min = arr[i];
			} else if (arr[i] > min) {
				if (secondMin == Integer.MAX_VALUE || secondMin > arr[i]) {
					secondMin = arr[i];
				}
			}
		}
		result[0] = secondMax;
		result[1] = secondMin;
		return result;
	}

}
