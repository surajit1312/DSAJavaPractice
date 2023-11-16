/**
 * 
 */
package com.dsa.linkedlist.medium;

/**
 * CodingNinjas Link: https://www.codingninjas.com/studio/problems/delete-kth-node-from-end_799912
 * 
 * TC: O(n)
 * SC: O(1)
 */
public class P4_LinkedList_Delete_Kth_Node_From_End {

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
		int[] input = { 1, 2, 3 };
		int K = 3;
		SinglyLinkedList linkedList = new SinglyLinkedList();
		Node head = linkedList.getListFromArray(input);
		System.out.println("LinkedList looks like : " + linkedList.printLinkedList(head));

		Node listKthDeletedFromEnd = removeKthNode(head, K);
		System.out.println("LinkedList after mid element deletion looks like : "
				+ linkedList.printLinkedList(listKthDeletedFromEnd));
	}

	public static Node removeKthNode(Node head, int K) {
		if (head == null) {
			return null;
		}
		Node slow = head;
		Node fast = head;
		for (int i = 0; i < K; i++) {
			if (fast.next == null) {
				head = head.next;
				return head;
			}
			fast = fast.next;
		}
		while (slow != null && fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next;
		}
		slow.next = slow.next.next;
		return head;
	}

}
