/**
 * 
 * Coding Ninjas
 * 
 * Link: https://www.codingninjas.com/studio/problems/trie-implementation_1062581
 * Link: https://www.codingninjas.com/studio/problems/trie-delete-operation_1062663
 * 
 */
package com.dsa.trie.medium;

import java.util.Arrays;
import java.util.Stack;

abstract class TrieNode {
	TrieNode children[] = new TrieNode[26];
	boolean isEnd;

	TrieNode() {
		this.isEnd = false;
		for (int i = 0; i < 26; i++)
			children[i] = null;
	}
}

class TrieNodePure extends TrieNode {
	TrieNodePure children[] = new TrieNodePure[26];
	boolean isEnd;

	TrieNodePure() {
		this.isEnd = false;
		Arrays.fill(children, null);
	}

	public void insert(String word) {

	}

	public boolean search(String word) {
		return true;
	}

	public boolean startsWith(String word) {
		return true;
	}
};

class Solution extends TrieNodePure {

	TrieNodePure root = new TrieNodePure();

	public boolean containsKey(TrieNode node, char c) {
		return node.children[c - 'a'] != null;
	}

	public void put(TrieNode node, char c, TrieNode newnode) {
		node.children[c - 'a'] = newnode;
	}

	public TrieNode get(TrieNode node, char c) {
		return node.children[c - 'a'];
	}

	public void setEnd(TrieNode node) {
		node.isEnd = true;
	}

	public void insert(String word) {
		TrieNode node = root;
		for (char c : word.toCharArray()) {
			if (!containsKey(node, c)) {
				put(node, c, new Solution());
			}
			node = get(node, c);
		}
		setEnd(node);
	}

	public boolean search(String word) {
		TrieNode node = root;
		for (char c : word.toCharArray()) {
			if (!containsKey(node, c)) {
				return false;
			}
			node = get(node, c);
		}
		return node.isEnd;
	}

	public boolean startsWith(String word) {
		TrieNode node = root;
		for (char c : word.toCharArray()) {
			if (!containsKey(node, c)) {
				return false;
			}
			node = get(node, c);
		}
		return node != null;
	}

	public TrieNode deleteWord(String word) {
		TrieNode node = root;
		Stack<Pair> st = new Stack<Pair>();
		if (!search(word)) {
			return null;
		}
		for (char c : word.toCharArray()) {
			node = get(node, c);
			st.add(new Pair(c, node));
		}
		while (!st.isEmpty()) {
			Pair currentpair = st.pop();
			char c = currentpair.c;
			currentpair.node.children[c - 'a'] = null;
		}
		return node;
	}
}

class Pair {
	char c;
	TrieNode node;

	public Pair(char c, TrieNode node) {
		this.c = c;
		this.node = node;
	}
}

/**
 * 
 */
public class P2_Implement_Trie_Delete_Operation_Coding_Ninjas {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Solution sol = new Solution();
		String value[] = { "hello", "help", "help", "hel", "hel" };
		for (String item : value) {
			sol.insert(item);
			System.out.println("'" + item + "' has been inserted into Trie");
		}
		boolean isSearched1 = sol.search(value[1]);
		System.out.println("Is '" + value[1] + "' present in Trie : " + isSearched1);

		boolean isSearched2 = sol.search(value[3]);
		System.out.println("Is '" + value[3] + "' present in Trie : " + isSearched2);

		boolean isSearched3 = sol.search("hell");
		System.out.println("Is 'hell' present in Trie : " + isSearched3);

		boolean doesStartWith1 = sol.startsWith("he");
		System.out.println("Is prefix 'he' present in Trie : " + doesStartWith1);

		boolean doesStartWith2 = sol.startsWith("ho");
		System.out.println("Is prefix 'ho' present in Trie : " + doesStartWith2);

		sol.deleteWord(value[0]);
		boolean isSearched = sol.search(value[0]);
		System.out.println("Is '" + value[0] + "' present in Trie : " + isSearched);
	}

}
