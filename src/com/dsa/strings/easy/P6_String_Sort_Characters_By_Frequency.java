/**
 * 
 */
package com.dsa.strings.easy;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 
 * LeetCode 451. Sort Characters By Frequency 
 * 
 * Link: https://leetcode.com/problems/sort-characters-by-frequency/
 * 
 * TC: O(nlog(n)) SC: O(2n) ~ O(n)
 * 
 */
public class P6_String_Sort_Characters_By_Frequency {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int n = 7;
		String s = "gggjhhh";
		String result = sortByFrequency(n, s);
		System.out.println("String " + s + " after sorting by Frequency is : " + result);
	}

	public static String sortByFrequency(int n, String s) {
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		PriorityQueue<Character> pq = new PriorityQueue<Character>((x, y) -> map.get(y) - map.get(x));
		for (char c : s.toCharArray()) {
			map.put(c, (map.getOrDefault(c, 0) + 1));
		}
		for (char c : map.keySet()) {
			pq.offer(c);
		}
		StringBuilder sb = new StringBuilder();
		while (!pq.isEmpty()) {
			Character ch = pq.poll();
			for (int i = 0; i < map.get(ch); i++) {
				sb.append(ch);
			}
		}
		return sb.toString();
	}

}
