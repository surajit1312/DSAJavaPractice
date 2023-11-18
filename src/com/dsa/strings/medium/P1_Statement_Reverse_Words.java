/**
 * 
 */
package com.dsa.strings.medium;

/**
 * 
 * CodingNinjas
 * Link: https://www.codingninjas.com/studio/problems/reverse-words_7037425
 * 
 * LeetCode 151. Reverse Words in a String
 * Link: https://leetcode.com/problems/reverse-words-in-a-string/submissions/1101544228/
 */
public class P1_Statement_Reverse_Words {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String str = "a good   example";
		String reverse = revWords(str);
		System.out.println("Reverse of '" + str + "' is : '" + reverse + "'");
	}
	
	private static String revWords(String str) {
		str = str.trim();
        String[] words = str.split(" ");
        String rev = "";
        for (int i = words.length - 1; i >= 0; i--) {
        	if (words[i] != "") {
        		if (rev.equals("")) {
        			rev += words[i];
        		} else {
        			rev += " " + words[i];
        		}
        	}
        }
        return rev;
    }

}
