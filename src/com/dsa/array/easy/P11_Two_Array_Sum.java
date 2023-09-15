/**
 * 
 */
package com.dsa.array.easy;

/**
 * 
 */
public class P11_Two_Array_Sum {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] a = { 1, 2, 3, 4 };
		int n = 4;
		int[] b = { 6 };
		int m = 1;
		int[] arraySum = findArraySum(a, n, b, m);
		for (int i = 0; i < arraySum.length; i++) {
			System.out.print(arraySum[i] + ",");
		}
	}

	private static int[] findArraySum(int[] a, int n, int[] b, int m) {
		int result1 = 0, result2 = 0;
		for (int i = 0; i < n; i++) {
			result1 += a[i] * Math.pow(10, n - i - 1);
		}
		for (int i = 0; i < m; i++) {
			result2 += b[i] * Math.pow(10, m - i - 1);
		}
		int sum = result1 + result2;
		int total = result1 + result2;
		int count = 0;
		while (total > 0) {
			total = total / 10;
			count++;
		}
		int size = count;
		int[] arr = new int[size];
		int cnt = 0;
		while (sum > 0) {
			arr[size - cnt - 1] = sum % 10;
			sum = sum / 10;
			cnt++;
		}
		return arr;
	}

}
