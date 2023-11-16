/**
 * 
 */
package com.dsa.linkedlist.easy;

/**
 * CodingNinjas Link: https://www.codingninjas.com/studio/problems/delete-middle-node_763267
 * 
 * TC: O(n)
 * SC: O(1)
 * 
 */
public class P10_Delete_Middle_Element_LinkedList {

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
		int[] input = { 1, 2, 3, 4, 5 };
		SinglyLinkedList linkedList = new SinglyLinkedList();
		Node head = linkedList.getListFromArray(input);
		System.out.println("LinkedList looks like : " + linkedList.printLinkedList(head));

		Node listMidDeleted = deleteMiddle(head);
		System.out.println(
				"LinkedList after mid element deletion looks like : " + linkedList.printLinkedList(listMidDeleted));
	}

	public static Node deleteMiddle(Node head) {
		if (head == null || head.next == null) {
			return null;
		}
		Node slow = head;
		Node fast = head;
		while (slow != null && fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		if (slow.next == null) {
			head.next = null;
			return head;
		}
		slow.data = slow.next.data;
		slow.next = slow.next.next;
		return head;
	}

}
