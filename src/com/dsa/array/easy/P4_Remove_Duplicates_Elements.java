/**
 * 
 */
package com.dsa.array.easy;

import java.util.ArrayList;

/**
 * 
 * Remove duplicate elements from the array and create a new array and return
 * it's size Link:
 * https://www.codingninjas.com/studio/problems/remove-duplicates-from-sorted-array_1102307
 * 
 */
public class P4_Remove_Duplicates_Elements {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] input1 = { 1, 2, 2, 2, 3 };
		int n1 = 5;
		ArrayList<Integer> arr1 = getArrayList(input1, n1);
		int sizeOfUniqueArray1 = removeDuplicates(arr1, n1);
		System.out.println("Size of unique array is: " + sizeOfUniqueArray1);

		int[] input2 = { 1, 2, 2, 3, 3, 3, 4, 4, 5, 5 };
		int n2 = 10;
		ArrayList<Integer> arr2 = getArrayList(input2, n2);
		int sizeOfUniqueArray2 = removeDuplicates(arr2, n2);
		System.out.println("Size of unique array is: " + sizeOfUniqueArray2);
	}

	private static ArrayList<Integer> getArrayList(int[] a, int n) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		for (int i = 0; i < n; i++) {
			result.add(a[i]);
		}
		return result;
	}

	public static int removeDuplicates(ArrayList<Integer> arr, int n) {
		int pointer = 0;
		for (int i = 1; i < arr.size(); i++) {
			if (arr.get(pointer) != arr.get(i)) {
				arr.set(pointer + 1, arr.get(i));
				pointer++;
			}
		}
		return pointer + 1;
	}

}
