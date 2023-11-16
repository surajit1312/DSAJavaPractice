/**
 * 
 */
package com.dsa.linkedlist.medium;

import java.util.Arrays;

/**
 * CodingNinjas Link: https://www.codingninjas.com/studio/problems/-intersection-of-two-linked-lists_630457
 * 
 * TC: O(2M) where M and N are length of two linked lists where M > N
 * SC: O(1)
 */
public class P5_Intersection_Node_Two_LinkedLists {

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

		public Node addIntersectedList(int[] list, Node target) {
			Node head = getListFromArray(Arrays.copyOf(list, list.length - 1));
			Node current = target;
			while (current.next != null && current.data != list[list.length - 1]) {
				current = current.next;
			}
			Node dummy = head;
			while (dummy.next != null) {
				dummy = dummy.next;
			}
			dummy.next = current;
			return head;
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] input1 = { 2, 4, 3, 7, 8, 10, 11 };
		int[] input2 = { 5, 6, 7 };

		SinglyLinkedList linkedList1 = new SinglyLinkedList();
		Node list1 = linkedList1.getListFromArray(input1);

		SinglyLinkedList linkedList2 = new SinglyLinkedList();
		Node list2 = linkedList2.addIntersectedList(input2, list1);
		System.out.println("LinkedList 1 looks like : " + linkedList1.printLinkedList(list1));
		System.out.println("LinkedList 2 looks like : " + linkedList2.printLinkedList(list2));

		int intersectionNode = findIntersection(list1, list2);
		System.out.println("The LinkedLists got intersected at node with value : " + intersectionNode);
	}

	private static int findIntersection(Node firstHead, Node secondHead) {
		if (firstHead == null || secondHead == null) {
			return -1;
		}
		Node a = firstHead;
		Node b = secondHead;
		while (a != b) {
			a = a == null ? secondHead : a.next;
			b = b == null ? firstHead : b.next;
		}
		return a.data;
	}

}
