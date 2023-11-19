/**
 * 
 */
package com.dsa.trie.medium;

/**
 * 
 * CodingNinjas
 * 
 * Link: https://www.codingninjas.com/studio/problems/complete-string_2687860
 * 
 * TC: O(n + l) where l is the maximum length of string inserted
 */
public class P3_Trie_Complete_String {

	static class TrieNode {
		TrieNode[] children = new TrieNode[26];
		boolean flag = false;

		public TrieNode() {
		}

		public boolean containsKey(char c) {
			return children[c - 'a'] != null;
		}

		public void put(char c, TrieNode node) {
			children[c - 'a'] = node;
		}

		public TrieNode get(char c) {
			return children[c - 'a'];
		}

		public void setEnd() {
			flag = true;
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
				if (!node.containsKey(c)) {
					return false;
				}
				node = node.get(c);
			}
			return node.flag;
		}

		public boolean checkIfAllPrefixExists(String word) {
			boolean flag = true;
			TrieNode node = root;
			for (char c : word.toCharArray()) {
				if (node.containsKey(c)) {
					node = node.get(c);
					flag = flag && node.flag;
				} else {
					return false;
				}
			}
			return flag;
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int n = 6;
		String[] inputs = { "n", "ni", "nin", "ninj", "ninja", "ninga" };
		String longestString = completeString(n, inputs);
		System.out.println("Longest prefix string found in Trie is : " + longestString);
	}

	public static String completeString(int n, String[] a) {
		Trie trie = new Trie();
		String longest = "";
		for (String s : a) {
			trie.insert(s);
		}
		for (int i = 0; i < n; i++) {
			if (trie.checkIfAllPrefixExists(a[i])) {
				if (longest.length() < a[i].length()) {
					longest = a[i];
				} else if (longest.length() == a[i].length() && a[i].compareTo(longest) < 0) {
					longest = a[i];
				}
			}
		}
		if (longest == "") {
			return "None";
		}
		return longest;
	}

}
