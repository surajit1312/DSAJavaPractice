/**
 * 
 */
package com.dsa.dynamicprogramming.medium;

/**
 * 
 */
public class P1_Count_Ways_To_Reach_Nth_Stairs {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		long n = 49;
		Long numWaysToClimbNthStair = countDistinctWayToClimbStair(n);
		System.out.println("Number of ways to climb " + n + "th stairs : " + numWaysToClimbNthStair);
	}

	public static Long countDistinctWayToClimbStair(long nStairs) {
		int n = Math.toIntExact(nStairs);
		if (n == 0 || n == 1) {
			return 1L;
		}
		Long[] dpArr = new Long[n + 1];
		// num ways to climb 0 and 1 stair is respectively 1 way and 1 way
		dpArr[0] = 1L;
		dpArr[1] = 1L;
		for (int i = 2; i <= n; i++) {
			dpArr[i] = dpArr[i - 2] + dpArr[i - 1];
		}
		return dpArr[n];
	}

}
