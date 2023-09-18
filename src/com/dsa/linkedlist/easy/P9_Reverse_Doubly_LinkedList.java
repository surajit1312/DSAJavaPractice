/**
 * 
 */
package com.dsa.linkedlist.easy;

/**
 * 
 */
public class P9_Reverse_Doubly_LinkedList {

	private DoubleNode head;

	private DoubleNode addLast(int data) {
		DoubleNode newNode = new DoubleNode(data);
		if (head == null) {
			head = newNode;
			return head;
		}
		DoubleNode currentNode = head;
		while (currentNode.next != null) {
			currentNode = currentNode.next;
		}
		newNode.prev = currentNode;
		currentNode.next = newNode;
		return currentNode;
	}

	private static DoubleNode constructDLL(int[] arr) {
		P9_Reverse_Doubly_LinkedList solution = new P9_Reverse_Doubly_LinkedList();
		for (int i = 0; i < arr.length; i++) {
			solution.addLast(arr[i]);
		}
		return solution.head;
	}

	private static void printLinkedList(DoubleNode node) {
		if (node == null) {
			System.out.print("NULL");
		}
		DoubleNode currentNode = node;
		while (currentNode != null) {
			System.out.print(currentNode.data + " <--> ");
			currentNode = currentNode.next;
		}
		System.out.println("NULL");
	}

	private static DoubleNode reverseDLL(DoubleNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		DoubleNode current = head;
		DoubleNode temp = null;
		while (current != null) {
			temp = current.prev;
			current.prev = current.next;
			current.next = temp;
			current = current.prev;
		}
		if (temp != null) {
			head = temp.prev;
		}
		return head;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8 };
		DoubleNode head = constructDLL(arr);
		printLinkedList(head);
		DoubleNode revHead = reverseDLL(head);
		printLinkedList(revHead);
	}

}
