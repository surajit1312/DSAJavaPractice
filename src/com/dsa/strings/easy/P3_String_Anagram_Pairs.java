/**
 * 
 */
package com.dsa.strings.easy;

import java.util.Arrays;

/**
 * CodingNinjas Link: https://www.codingninjas.com/studio/problems/anagram-pairs_626517
 * 
 * TC: O(2n)
 * SC: O(2n)
 */
public class P3_String_Anagram_Pairs {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String s1 = "pzjctvnobd", s2 = "exfhvsynqp";
		boolean anagramBool = isAnagram(s1, s2);
		System.out.println(anagramBool);
	}
	
	public static boolean isAnagram(String str1, String str2) {
		if (str1.length() != str2.length()) {
			return false;
		}
        int[] charA1 = new int[26];
        Arrays.fill(charA1, 0);
        int[] charA2 = new int[26];
        Arrays.fill(charA2, 0);
        for (int i = 0; i < str1.length(); i++) {
        	charA1[(int) str1.charAt(i) - 97]++;
        	charA2[(int) str2.charAt(i) - 97]++;
        }
        for (int i = 0; i < 26; i++) {
        	if (charA1[i] != charA2[i]) {
        		return false;
        	}
        }
        return true;
    }

}
