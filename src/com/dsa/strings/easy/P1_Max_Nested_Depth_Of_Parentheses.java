/**
 * 
 */
package com.dsa.strings.easy;

/**
 * CodingNinjas Link: https://www.codingninjas.com/studio/problems/maximum-nesting-depth-of-the-parentheses_8144741
 * 
 * TC: O(n)
 * SC: O(1)
 */
public class P1_Max_Nested_Depth_Of_Parentheses {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String input = "(3*(4*(5*(6))))";
		int maxParenthesesDepth = maxDepth(input);
		System.out.println("Maximum Depth of Parentheses in String '" + input + "' is : " + maxParenthesesDepth);
	}

	private static int maxDepth(String s) {
		int depth = 0;
		int max = 0;
		char openBracket = '(';
		char closeBracket = ')';
		char[] charArr = s.toCharArray();
		for (int i = 0; i < charArr.length; i++) {
			if (charArr[i] == openBracket) {
				depth++;
			}
			if (charArr[i] == closeBracket) {
				depth--;
			}
			max = Math.max(max, depth);
		}
		return max;
	}

}
