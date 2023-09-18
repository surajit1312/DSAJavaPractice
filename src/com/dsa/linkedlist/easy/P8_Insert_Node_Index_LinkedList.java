/**
 * 
 */
package com.dsa.linkedlist.easy;

class SinglyLinkedListNode {
	public int data;
	public SinglyLinkedListNode next;

	public SinglyLinkedListNode(int nodeData) {
		this.data = nodeData;
		this.next = null;
	}
}

class SinglyLinkedList {
	public SinglyLinkedListNode head;
	public SinglyLinkedListNode tail;

	public SinglyLinkedList() {
		this.head = null;
		this.tail = null;
	}

	public void insertNode(int nodeData) {
		SinglyLinkedListNode node = new SinglyLinkedListNode(nodeData);

		if (this.head == null) {
			this.head = node;
		} else {
			this.tail.next = node;
		}

		this.tail = node;
	}
}

/**
 * 
 */
public class P8_Insert_Node_Index_LinkedList {

	private SinglyLinkedListNode head;

	private void addLast(int data) {
		SinglyLinkedListNode newNode = new SinglyLinkedListNode(data);
		if (head == null) {
			head = newNode;
			return;
		}
		SinglyLinkedListNode currentNode = head;
		while (currentNode.next != null) {
			currentNode = currentNode.next;
		}
		currentNode.next = newNode;
	}
	
	private static SinglyLinkedListNode constructLL(int[] arr) {
		P8_Insert_Node_Index_LinkedList sol = new P8_Insert_Node_Index_LinkedList();
		for (int i = 0; i < arr.length; i++) {
			sol.addLast(arr[i]);
		}
		return sol.head;
	}

	private static void printLinkedList(SinglyLinkedListNode head) {
		SinglyLinkedListNode currentNode = head;
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
		SinglyLinkedListNode head = constructLL(arr);
		printLinkedList(head);
		SinglyLinkedListNode newList = insertNodeAtPosition(head, 7, 2);
		printLinkedList(newList);
	}

	public static SinglyLinkedListNode insertNodeAtPosition(SinglyLinkedListNode llist, int data, int position) {
		if (llist == null) {
			if (position == 0) {
				llist = new SinglyLinkedListNode(data);
			} else {
				return llist;
			}
		}
		SinglyLinkedListNode currentNode = llist;
		int count = 0;
		SinglyLinkedListNode tempNode = null;
		while (currentNode != null && currentNode.next != null) {
			count++;
			currentNode = currentNode.next;
			if (count == position - 1) {
				tempNode = currentNode.next;
				break;
			}
		}
		SinglyLinkedListNode newNode = new SinglyLinkedListNode(data);
		newNode.next = tempNode;
		currentNode.next = newNode;
		return llist;
	}

}
