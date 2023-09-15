/**
 * 
 */
package com.dsa.linkedlist.medium;

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
 * Given a singly linked list of 'N' nodes. The objective is to determine the
 * middle node of a singly linked list. However, if the list has an even number
 * of nodes, we return the second middle node.
 * 
 * Link:
 * https://www.codingninjas.com/studio/problems/middle-of-linked-list_973250
 * 
 */
public class P1_Middle_LinkedList {

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
		P1_Middle_LinkedList sol = new P1_Middle_LinkedList();
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

	private static Node findMiddle(Node head) {
		if (head == null) {
			return null;
		}
		if (head.next == null) {
			return head;
		}
		Node slow = head;
		Node fast = head;
		while (slow != null && fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5, 6, 7 };
		System.out.println("LinkedList");
		Node head = constructLL(arr);
		printLinkedList(head);

		System.out.println("Middle of LinkedList");
		Node middle = findMiddle(head);
		printLinkedList(middle);
	}

}
