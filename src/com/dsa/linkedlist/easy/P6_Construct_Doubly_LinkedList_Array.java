/**
 * 
 */
package com.dsa.linkedlist.easy;

/*
 * ***************************************************************

  Following is the class structure of the Node class:
*/

class DoubleNode {

	public int data;
	public DoubleNode next;
	public DoubleNode prev;

	DoubleNode() {
		this.data = 0;
		this.next = null;
		this.prev = null;
	}

	DoubleNode(int data) {
		this.data = data;
		this.next = null;
		this.prev = null;
	}

	DoubleNode(int data, DoubleNode next, DoubleNode prev) {
		this.data = data;
		this.next = next;
		this.prev = prev;
	}
};

/*****************************************************************
 * 
 */

/**
 * 
 * You are given an array 'Arr' of size 'N' consisting of positive integers.
 * Your task is to make a doubly linked list from the array and return the head
 * of the linked list. Here, the head of the doubly linked list is the first
 * element of the array, and the tail of the doubly linked list is the last
 * element.
 * 
 * Note: A doubly linked list is one in which it is possible to access the next
 * and the previous nodes from a node in the linked list (if they exist).
 * 
 * Input: ‘N’ = 4, ‘Arr’ = [4, 2, 5, 1]
 * 
 * Output: 4 2 5 1
 * 
 * Explanation:
 * 
 * Doubly Linked List for the array ‘Arr’ = [4, 2, 5, 1] is 4 <-> 2 <-> 5 <-> 1.
 * 
 * Link:
 * https://www.codingninjas.com/studio/problems/introduction-to-doubly-linked-list_8160413
 * 
 */
public class P6_Construct_Doubly_LinkedList_Array {

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
		P6_Construct_Doubly_LinkedList_Array solution = new P6_Construct_Doubly_LinkedList_Array();
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

	private static DoubleNode addLastAgain(DoubleNode list, int data) {
		DoubleNode newNode = new DoubleNode(data);
		if (list == null) {
			list = newNode;
			return list;
		}
		DoubleNode currentNode = list;
		while (currentNode.next != null) {
			currentNode = currentNode.next;
		}
		currentNode.next = newNode;
		newNode.prev = currentNode;
		return list;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr = { 4, 2, 5, 1 };
		DoubleNode head = constructDLL(arr);
		printLinkedList(head);
		DoubleNode list = addLastAgain(head, 8);
		printLinkedList(list);
	}

}
