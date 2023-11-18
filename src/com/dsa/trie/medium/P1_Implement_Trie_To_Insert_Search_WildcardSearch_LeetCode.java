/**
 * 
 */
package com.dsa.trie.medium;

/**
 * 
 * Leetcode 208. Implement Trie (Prefix Tree)
 * 
 * Link: https://leetcode.com/problems/implement-trie-prefix-tree/
 * 
 */
public class P1_Implement_Trie_To_Insert_Search_WildcardSearch_LeetCode {

	static class TrieNode {
		TrieNode[] children = new TrieNode[26];
		boolean isEnd = false;

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
			isEnd = true;
		}
	}

	static class Trie extends TrieNode {
		TrieNode root;

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
			return node.isEnd;
		}

		public boolean startsWith(String word) {
			TrieNode node = root;
			for (char c : word.toCharArray()) {
				if (!node.containsKey(c)) {
					return false;
				}
				node = node.get(c);
			}
			return node != null;
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Trie trie = new Trie();
		String value[] = { "hello", "help", "help", "hel", "hel" };
		for (String item : value) {
			trie.insert(item);
			System.out.println("'" + item + "' has been inserted into Trie");
		}
		boolean isSearched1 = trie.search(value[1]);
		System.out.println("Is '" + value[1] + "' present in Trie : " + isSearched1);

		boolean isSearched2 = trie.search(value[3]);
		System.out.println("Is '" + value[3] + "' present in Trie : " + isSearched2);

		boolean isSearched3 = trie.search("hell");
		System.out.println("Is 'hell' present in Trie : " + isSearched3);

		boolean doesStartWith1 = trie.startsWith("he");
		System.out.println("Is prefix 'he' present in Trie : " + doesStartWith1);

		boolean doesStartWith2 = trie.startsWith("ho");
		System.out.println("Is prefix 'ho' present in Trie : " + doesStartWith2);
	}

}
