/**
 * 
 */
package com.dsa.trie.medium;

import java.util.Arrays;

/**
 * 
 * CodingNinjas
 * 
 * Link:
 * 
 * https://www.codingninjas.com/studio/problems/count-distinct-substrings_985292
 * 
 * TC: O(n^2) 
 * 
 * SC: Hypothetical - Array of 26 takes again array of 26 and so on ...
 * 
 */
public class P4_Count_Distinct_Substrings_Using_Trie {

	static class TrieNode {

		TrieNode[] children;
		boolean isEnd;

		public TrieNode() {
			children = new TrieNode[26];
			Arrays.fill(children, null);
		}

		public boolean containsKey(char c) {
			return children[c - 'a'] != null;
		}

		public void put(char c, TrieNode node) {
			children[c - 'a'] = node;
			;
		}

		public TrieNode get(char c) {
			return children[c - 'a'];
		}

		public void setEnd() {
			isEnd = true;
		}

	}

	static class Trie {

		private TrieNode root;

		public Trie() {
			root = new TrieNode();
		}

		public void insert(String word) {
			TrieNode node = root;
			for (char c : word.toCharArray()) {
				if (!node.containsKey(c)) {
					node.put(c, new TrieNode());
				}
				node = node.get(c);
			}
			node.setEnd();
		}

		public boolean search(String word) {
			TrieNode node = root;
			for (char c : word.toCharArray()) {
				if (node.containsKey(c)) {
					node = node.get(c);
				} else {
					return false;
				}
			}
			return node.isEnd;
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String word = "abab";
		Trie trie = new Trie();
		trie.insert(word);
		boolean wordExists = trie.search(word);
		System.out.println("Word " + word + " exists in Trie : " + wordExists);
		int numDistinctSubstrings = countDistinctSubstrings(word);
		System.out.println("Count of distinct substrings in word '" + word + "' is : " + numDistinctSubstrings);
	}

	public static int countDistinctSubstrings(String s) {
		TrieNode root = new TrieNode();
		int count = 0;
		for (int i = 0; i < s.length(); i++) {
			TrieNode node = root;
			for (int j = i; j < s.length(); j++) {
				if (!node.containsKey(s.charAt(j))) {
					node.put(s.charAt(j), new TrieNode());
					count++;
				}
				node = node.get(s.charAt(j));
			}
		}
		return count + 1;
	}
}
