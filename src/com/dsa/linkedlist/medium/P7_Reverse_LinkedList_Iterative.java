/**
 * 
 */
package com.dsa.linkedlist.medium;

/**
 * 
 * CodingNinjas
 * 
 * Link:
 * 
 * https://www.codingninjas.com/studio/problems/reverse-linked-list_920513
 * 
 * TC: O(n)
 * SC: O(1)
 * 
 */
public class P7_Reverse_LinkedList_Iterative {

	static class Node {
		int data;
		Node next;

		public Node(int data) {
			this.data = data;
			this.next = null;
		}
	}

	static class SinglyLinkedList {
		Node head;

		public void appendItem(int val) {
			Node newNode = new Node(val);
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

		public Node getListFromArray(int[] list) {
			for (Integer i : list) {
				if (i >= 0)
					appendItem(i);
			}
			return head;
		}

		public String printLinkedList(Node head) {
			String listPath = "";
			if (head == null) {
				listPath = "NULL";
			}
			Node current = head;
			while (current != null) {
				listPath += current.data + " --> ";
				current = current.next;
			}
			listPath += "NULL";
			return listPath;
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] input = { 1, 2, 3, 4, 5, 6, 7 };
		SinglyLinkedList linkedList = new SinglyLinkedList();
		Node head = linkedList.getListFromArray(input);
		System.out.println("LinkedList looks like : " + linkedList.printLinkedList(head));

		Node reverseNode = reverseLinkedList(head);
		System.out.println("LinkedList looks like : " + linkedList.printLinkedList(reverseNode));
	}

	public static Node reverseLinkedList(Node head) {
		Node current = head;
		Node prev = null;

		while (current != null) {
			Node temp = current.next;
			current.next = prev;
			prev = current;
			current = temp;
		}

		return prev;
	}

}
