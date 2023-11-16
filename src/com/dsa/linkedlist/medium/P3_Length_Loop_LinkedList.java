/**
 * 
 */
package com.dsa.linkedlist.medium;

/**
 * CodingNinjas Link: https://www.codingninjas.com/studio/problems/find-length-of-loop_8160455
 * 
 * TC: O(n)
 * SC: O(1)
 */
public class P3_Length_Loop_LinkedList {

	static class Node {
		int val;
		Node next;

		public Node(int val) {
			this.val = val;
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
				listPath += current.val + " --> ";
				current = current.next;
			}
			listPath += "NULL";
			return listPath;
		}

		public Node addCycleToLinkedList(Node head, int toIndex) {
			if (head == null) {
				return head;
			}
			Node current = head;
			Node pointListNode = null;
			int index = 0;
			while (current.next != null) {
				if (toIndex == index) {
					pointListNode = current;
				}
				current = current.next;
				index++;
			}
			current.next = pointListNode;
			return head;
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] input = { 4, 10, 3, 5, 10 };
		SinglyLinkedList linkedList = new SinglyLinkedList();
		Node head = linkedList.getListFromArray(input);
		System.out.println("LinkedList looks like : " + linkedList.printLinkedList(head));

		int connectedIndex = 2;
		Node cyclicLinkedList = linkedList.addCycleToLinkedList(head, connectedIndex);
		System.out.println("Tail of LinkedList connects to index : " + connectedIndex);
		System.out.println("Length of loop of LinkedList: " + lengthOfLoop(cyclicLinkedList));
	}

	public static int lengthOfLoop(Node head) {
		int countLoop = 0;
		if (head == null) {
			return 0;
		}
		Node slow = head;
		Node fast = head;
		while (slow.next != null && fast.next != null & fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				slow = slow.next;
				while (slow != fast) {
					slow = slow.next;
					countLoop++;
				}
				return countLoop + 1;
			}
		}
		return countLoop;
	}

}
