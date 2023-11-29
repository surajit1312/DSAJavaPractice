/**
 * 
 */
package com.dsa.linkedlist.medium;

import java.util.Arrays;

/**
 * 
 * CodingNinjas: Check If Linked List Is Palindrome
 * 
 * Link:
 * 
 * https://www.codingninjas.com/studio/problems/check-if-linked-list-is-palindrome_985248
 * 
 * TC: O(n/2) (mid-point of list) + O(n/2) (reverse 2nd half of LinkedList) +
 *     O(n/2) (traverse 2 halves) ~ O(n)
 * 
 * SC: O(1)
 * 
 */
public class P9_LinkedList_Palindrome_Check {

	static class Node {

		int data;
		Node next;

		public Node() {
			this.data = 0;
			this.next = null;
		}

		public Node(int data) {
			this.data = data;
			this.next = null;
		}

		public Node(int data, Node next) {
			this.data = data;
			this.next = next;
		}
	}

	static class LinkedList {
		Node head;

		public void append(int data) {
			if (data == -1) {
				return;
			}
			Node newNode = new Node(data);
			if (head == null) {
				head = newNode;
				return;
			}
			Node current = head;
			while (current.next != null) {
				current = current.next;
			}
			current.next = newNode;
		}

		public Node getLinkedListFromArray(int[] dataArr) {
			for (int i = 0; i < dataArr.length; i++) {
				append(dataArr[i]);
			}
			return head;
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] nums1 = { 1, 2, 2, 1, -1 };
		LinkedList list1 = new LinkedList();
		Node head1 = list1.getLinkedListFromArray(nums1);
		boolean checkIfPalindrome1 = isPalindrome(head1);
		System.out.println("Is LinkedList " + Arrays.toString(nums1) + " palindrome : " + checkIfPalindrome1);

		int[] nums2 = { 1, 2, 2, 3, -1 };
		LinkedList list2 = new LinkedList();
		Node head2 = list2.getLinkedListFromArray(nums2);
		boolean checkIfPalindrome2 = isPalindrome(head2);
		System.out.println("Is LinkedList " + Arrays.toString(nums2) + " palindrome : " + checkIfPalindrome2);
	}

	private static boolean isPalindrome(Node head) {
		if (head == null) {
			return false;
		}
		if (head.next == null) {
			return true;
		}
		Node mid = null;
		Node slow = head, fast = head;
		int count = 0;
		while (slow != null && fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			count++;
		}
		mid = slow;
		boolean isOdd = count % 2 != 0;
		Node firstListNode = head;
		Node secondListNode = isOdd ? reverseLinkedList(mid.next) : reverseLinkedList(mid);
		boolean isValidPalindrome = true;
		while (firstListNode != null && secondListNode != null) {
			if (firstListNode.data != secondListNode.data) {
				isValidPalindrome = false;
				break;
			}
			firstListNode = firstListNode.next;
			secondListNode = secondListNode.next;
		}
		return isValidPalindrome;
	}

	private static Node reverseLinkedList(Node node) {
		Node prevNode = null;
		Node currentNode = node;
		while (currentNode != null) {
			Node tempNode = currentNode.next;
			currentNode.next = prevNode;
			prevNode = currentNode;
			currentNode = tempNode;
		}
		return prevNode;
	}

}
