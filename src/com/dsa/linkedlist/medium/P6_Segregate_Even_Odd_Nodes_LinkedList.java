/**
 * 
 */
package com.dsa.linkedlist.medium;

/**
 * CodingNinjas Link: https://www.codingninjas.com/studio/problems/segregate-even-and-odd-nodes-in-a-linked-list_1116100
 * 
 * TC: O(n)
 * SC: O(1)
 */
public class P6_Segregate_Even_Odd_Nodes_LinkedList {

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
		int[] input = { 6, 5, 3, 4, 7, 1, 2 };
		SinglyLinkedList linkedList1 = new SinglyLinkedList();
		Node head = linkedList1.getListFromArray(input);
		System.out.println("LinkedList looks like : " + linkedList1.printLinkedList(head));

		SinglyLinkedList linkedList2 = new SinglyLinkedList();
		Node segregatedEvenOddList = segregateEvenOdd(head);
		System.out.println("Segregated Even Odd LinkedList looks like : " + linkedList2.printLinkedList(segregatedEvenOddList));
	}

	private static Node segregateEvenOdd(Node head) {
		if (head == null) {
			return null;
		}
		Node current = head;
		Node eHead = null, eTail = null, oHead = null, oTail = null;
		while (current != null) {
			if (current.data % 2 == 0) {
				if (eHead == null) {
					eHead = eTail = current;
				} else {
					eTail.next = current;
					eTail = eTail.next;
				}
			} else {
				if (oHead == null) {
					oHead = oTail = current;
				} else {
					oTail.next = current;
					oTail = oTail.next;
				}
			}
			current = current.next;
		}
		if (oHead == null) {
			return oTail;
		}
		if (eHead == null) {
			return oHead;
		}
		oTail.next = null;
		eTail.next = oHead;
		return eHead;
	}

}
