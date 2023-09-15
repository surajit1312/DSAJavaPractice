/**
 * 
 */
package com.dsa.linkedlist.easy;

/****************************************************************

Following is the class structure of the Node class:

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

*****************************************************************/

/**
 *
 * A doubly-linked list is a data structure that consists of sequentially linked
 * nodes, and the nodes have reference to both the previous and the next nodes
 * in the sequence of nodes. Given a doubly-linked list, delete the node at the
 * end of the doubly linked list.
 * 
 * Input: Linked List: 4 <-> 10 <-> 3 <-> 5 <-> 20
 * 
 * Output: Modified Linked List: 4 <-> 10 <-> 3 <-> 5
 * 
 * Explanation: The last node having ‘data’ = 20 is removed from the linked
 * list.
 * 
 * Link:
 * https://www.codingninjas.com/studio/problems/delete-last-node-of-a-doubly-linked-list_8160469
 * 
 */
public class P7_Delete_Last_Node_Doubly_LinkedList {

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
		P7_Delete_Last_Node_Doubly_LinkedList solution = new P7_Delete_Last_Node_Doubly_LinkedList();
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

	public static DoubleNode deleteLastNode(DoubleNode head) {
		if (head == null || head.next == null) {
			return null;
		}
		DoubleNode currentNode = head;
		DoubleNode secondLastNode = null;
		while (currentNode.next != null) {
			secondLastNode = currentNode;
			currentNode = currentNode.next;
		}
		secondLastNode.next = null;
		return head;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr = { 4, 2, 5, 1 };
		DoubleNode head = constructDLL(arr);
		printLinkedList(head);
		System.out.println("Before delete");
		printLinkedList(head);
		System.out.println("After delete");
		DoubleNode list = deleteLastNode(head);
		printLinkedList(list);
	}

}
