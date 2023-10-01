/**
 * 
 */
package com.dsa.stackqueues.easy;

import java.util.Stack;

/**
 * 
 * You're given a string 'S' consisting of "{", "}", "(", ")", "[" and "]".
 * Return true if the given string 'S' is balanced, else return false.
 * 
 * 'S' = "{}()".
 * 
 * There is always an opening brace before a closing brace i.e. '{' before '}',
 * '(' before '). So the 'S' is Balanced.
 * 
 * Link: https://www.codingninjas.com/studio/problems/valid-parentheses_795104
 * 
 */
public class P5_Valid_Parentheses {

	private static boolean isValidParenthesis(String s) {
		Stack<String> stack = new Stack<String>();
		boolean isValid = true;
		for (int i = 0; i < s.length(); i++) {
			String current = String.valueOf(s.charAt(i));
			if (isOpeningParentheses(current)) {
				stack.push(current);
			} else {
				if (stack.isEmpty()) {
					isValid = false;
					break;
				}
				String popped = stack.pop();
				if (!isMatchingParentheses(popped, current)) {
					isValid = false;
					break;
				}
			}
		}
		if (isValid && stack.isEmpty()) {
			isValid = true;
		}
		return isValid;
	}

	private static boolean isOpeningParentheses(String c) {
		return "[".equals(c) || "(".equals(c) || "{".equals(c);
	}

	private static boolean isMatchingParentheses(String popped, String current) {
		String compare = "";
		switch (current) {
		case "]":
			compare = "[";
			break;
		case "}":
			compare = "{";
			break;
		case ")":
			compare = "(";
			break;
		default:
			compare = "";
		}
		return popped.equals(compare);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String input1 = "[()]{}{[()()]()}";
		boolean output1 = isValidParenthesis(input1);
		System.out.println("The string " + input1 + " is balanced: " + output1);

		String input2 = "}])]";
		boolean output2 = isValidParenthesis(input2);
		System.out.println("The string " + input2 + " is balanced: " + output2);
	}

}
