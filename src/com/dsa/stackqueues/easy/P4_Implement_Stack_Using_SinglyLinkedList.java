/**
 * 
 * You must implement the Stack data structure using a Singly Linked List.
 * Create a class named 'Stack' which supports the following operations(all in O(1) time):
 * 
 * getSize: Returns an integer. Gets the current size of the stack
 * isEmpty: Returns a boolean. Gets whether the stack is empty
 * push: Returns nothing. Accepts an integer. Puts that integer at the top of the stack
 * pop: Returns nothing. Removes the top element of the stack. It does nothing if the stack is empty.
 * getTop: Returns an integer. Gets the top element of the stack. Returns -1 if the stack is empty
 * 
 * Link: https://www.codingninjas.com/studio/problems/implement-stack-with-linked-list_1279905
 */
package com.dsa.stackqueues.easy;

class Node {
	int data;
	Node next;

	Node() {
		this.data = 0;
		this.next = null;
	}

	Node(int data) {
		this.data = data;
		this.next = null;
	}

	Node(int data, Node next) {
		this.data = data;
		this.next = next;
	}
};

class StackP4 {
	private Node head;
	// Write your code here

	StackP4() {
		// Write your code here
	}

	int getSize() {
		if (head == null) {
			return 0;
		}
		int size = 0;
		Node current = head;
		while (current != null) {
			current = current.next;
			size++;
		}
		return size;
	}

	boolean isEmpty() {
		return head == null;
	}

	void push(int data) {
		Node newNode = new Node(data);
		if (head == null) {
			head = newNode;
			return;
		}
		newNode.next = head;
		head = newNode;
	}

	void pop() {
		if (head == null) {
			return;
		}
		head = head.next;
	}

	int getTop() {
		if (head == null) {
			return -1;
		}
		return head.data;
	}
}

/**
 * 
 */
public class P4_Implement_Stack_Using_SinglyLinkedList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		StackP4 s = new StackP4();
		s.push(1);
		s.push(2);
		s.push(3);

		while (!s.isEmpty()) {
			System.out.println(s.getTop());
			s.pop();
		}
	}

}
