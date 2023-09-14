/**
 * 
 */
package com.dsa.linkedlist.easy;

/****************************************************************
 * 
 * Following is the class structure of the Node class:
 */

class Node {
	public int data;
	public Node next;

	Node() {
		this.data = 0;
		this.next = null;
	}

	Node(int data) {
		this.data = data;
		this.next = null;
	}

	Node(int data, Node next) {
		this.data = data;
		this.next = next;
	}
};

/**
 * 
 * You are given an array 'Arr' of size 'n' consisting of positive integers.
 * Make a linked list from the array and return the head of the linked list.
 * 
 * The head of the linked list is the first element of the array, and the tail
 * of the linked list is the last element.
 * 
 * Note:
 * 
 * In the output, you will see the elements of the linked list made by you.
 * 
 * Input: ‘Arr’ = [4, 2, 5, 1]
 * 
 * Output: 4 2 5 1
 * 
 * Explanation:
 * 
 * Linked List for the array ‘Arr’ = [4, 2, 5, 1] is 4 -> 2 -> 5 -> 1.
 * 
 * Link:
 * https://www.codingninjas.com/studio/problems/introduction-to-linked-list_8144737
 * 
 */
public class P1_Construct_LinkedList_Array {

	private Node head;

	private void addLast(int data) {
		Node newNode = new Node(data);
		if (head == null) {
			head = newNode;
			return;
		}
		Node currentNode = head;
		while (currentNode.next != null) {
			currentNode = currentNode.next;
		}
		currentNode.next = newNode;
	}

	private static Node constructLL(int[] arr) {
		P1_Construct_LinkedList_Array sol = new P1_Construct_LinkedList_Array();
		for (int i = 0; i < arr.length; i++) {
			sol.addLast(arr[i]);
		}
		return sol.head;
	}

	private static void printLinkedList(Node head) {
		Node currentNode = head;
		while (currentNode != null) {
			System.out.print(currentNode.data + " --> ");
			currentNode = currentNode.next;
		}
		System.out.println("NULL");
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr = { 4, 2, 5, 1 };
		Node head = constructLL(arr);
		printLinkedList(head);
	}

}
