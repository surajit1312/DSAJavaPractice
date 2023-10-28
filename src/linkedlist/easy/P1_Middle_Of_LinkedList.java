/**
 * Leetcode 876. Middle of the Linked List
 * 
 * Given the head of a singly linked list, return the middle node of the linked list.
 * 
 * If there are two middle nodes, return the second middle node.
 * 
 * Example 1:
 * 
 * Input: head = [1,2,3,4,5]
 * Output: [3,4,5]
 * Explanation: The middle node of the list is node 3.
 * 
 * Example 2:
 * 
 * Input: head = [1,2,3,4,5,6]
 * Output: [4,5,6]
 * Explanation: Since the list has two middle nodes with values 3 and 4, we return the second one.
 * 
 * 
 * Link: https://leetcode.com/problems/middle-of-the-linked-list/description/
 * 
 */
package linkedlist.easy;

class ListNode {
	int data;
	ListNode next;

	public ListNode(int data) {
		this.data = data;
	}
}

class SinglyLinkedList {
	ListNode head;

	public void addItem(int value) {
		ListNode newNode = new ListNode(value);
		if (head == null) {
			head = newNode;
			return;
		}
		ListNode currentNode = head;
		while (currentNode.next != null) {
			currentNode = currentNode.next;
		}
		currentNode.next = newNode;
	}

	public void printLinkedList() {
		ListNode currentNode = head;
		while (currentNode != null) {
			System.out.print(currentNode.data + " -> ");
			currentNode = currentNode.next;
		}
		System.out.println("NULL");
	}
}

/**
 * 
 */
public class P1_Middle_Of_LinkedList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] input = { 1, 2, 3, 4, -5, 6, -7, 8, 9, -10 };
		SinglyLinkedList list = new SinglyLinkedList();
		for (Integer i : input) {
			list.addItem(i);
		}
		list.printLinkedList();
		ListNode middle = middleNode(list.head);
		printNode(middle);
	}

	private static void printNode(ListNode node) {
		ListNode currentNode = node;
		while (currentNode != null) {
			System.out.print(currentNode.data + " -> ");
			currentNode = currentNode.next;
		}
		System.out.println("NULL");
	}

	private static ListNode middleNode(ListNode head) {
		if (head == null) {
			return null;
		}
		if (head.next == null) {
			return head;
		}
		ListNode slow = head;
		ListNode fast = head;
		while (slow != null && fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}

}
