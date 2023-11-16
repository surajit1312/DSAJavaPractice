/**
 * Coding Ninjas 
 * 
 * Link1 : https://www.codingninjas.com/studio/problems/cycle-detection-in-a-singly-linked-list_628974
 * Link2 : https://www.codingninjas.com/studio/problems/linked-list-cycle-ii_1112628
 * 
 * TC: O(n)
 * 
 */
package com.dsa.linkedlist.medium;

/**
 * 
 */
public class P2_Detect_Cycle_Singly_LinkedList {

	static class ListNode {
		int val;
		ListNode next;

		public ListNode(int val) {
			this.val = val;
			this.next = null;
		}
	}

	static class SinglyLinkedList {
		ListNode head;

		public void appendItem(int val) {
			ListNode newNode = new ListNode(val);
			if (head == null) {
				head = newNode;
				return;
			}
			ListNode current = head;
			while (current.next != null) {
				current = current.next;
			}
			current.next = newNode;
		}

		public ListNode getListFromArray(int[] list) {
			for (Integer i : list) {
				if (i >= 0)
					appendItem(i);
			}
			return head;
		}

		public String printLinkedList(ListNode head) {
			String listPath = "";
			if (head == null) {
				listPath = "NULL";
			}
			ListNode current = head;
			while (current != null) {
				listPath += current.val + " --> ";
				current = current.next;
			}
			listPath += "NULL";
			return listPath;
		}

		public ListNode addCycleToLinkedList(ListNode head, int toIndex) {
			if (head == null) {
				return head;
			}
			ListNode current = head;
			ListNode pointListNode = null;
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
		int[] input = { 7885, 9040, 1770, 4481, 3720, 5736, 4281, 1180, 141, 5619, 6137, 2760, 8034, 2299, 4261, 4587,
				3938, 3287, 8554, 2805, 8741, 4059, 3070, 9559, 459, 2896, -1 };
		SinglyLinkedList linkedList = new SinglyLinkedList();
		ListNode head = linkedList.getListFromArray(input);
		boolean listHasCycle1 = detectCycle(head);
		System.out.println("LinkedList looks like : " + linkedList.printLinkedList(head));
		System.out.println("LinkedList has cycle : " + listHasCycle1);
		ListNode cycleStartedAt1 = firstNode(head);
		System.out.println("LinkedList cycle started at index : " + cycleStartedAt1);

		ListNode cyclicLinkedList = linkedList.addCycleToLinkedList(head, 12);
		boolean listHasCycle2 = detectCycle(cyclicLinkedList);
		System.out.println("LinkedList has cycle : " + listHasCycle2);
		ListNode cycleStartedAt2 = firstNode(cyclicLinkedList);
		System.out.println("LinkedList cycle started at index : " + cycleStartedAt2.val);
	}

	public static boolean detectCycle(ListNode head) {
		if (head == null) {
			return false;
		}
		ListNode slow = head;
		ListNode fast = head;
		while (slow != null && fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				return true;
			}
		}
		return false;
	}

	public static ListNode firstNode(ListNode head) {
		if (head == null) {
			return null;
		}
		ListNode slow = head;
		ListNode fast = head;
		ListNode entry = head;
		while (slow != null && fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				while (slow != entry) {
					slow = slow.next;
					entry = entry.next;
				}
				return entry;
			}
		}
		return null;
	}

}
