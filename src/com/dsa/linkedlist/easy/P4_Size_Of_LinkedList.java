/**
 * 
 */
package com.dsa.linkedlist.easy;

/****************************************************************

Following is the class structure of the Node class:

class Node {
    public int data;
    public Node next;
   
    Node()
    {
        this.data = 0;
        this.next = null;
    }
   
    Node(int data)
    {
        this.data = data;
        this.next = null;
    }
   
    Node(int data, Node next)
    {
        this.data = data;
        this.next = next;
    }
}

*****************************************************************/

/**
 * 
 * Given the head of a singly linked list of integers, find and return its
 * length. Note: Exercise caution when dealing with edge cases, such as when the
 * head is NULL. Failing to handle these edge cases appropriately may result in
 * a runtime error in your code.
 * 
 * Link:
 * https://www.codingninjas.com/studio/problems/count-nodes-of-linked-list_5884
 */
public class P4_Size_Of_LinkedList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		P4_Size_Of_LinkedList list = new P4_Size_Of_LinkedList();
		Node node = list.insertAtFirst(null, 1);
		node = list.insertAtFirst(node, 5);
		node = list.insertAtFirst(node, 2);
		node = list.insertAtFirst(node, 4);
		node = list.insertAtFirst(node, 0);
		printLinkedList(node);
		int size = length(node);
		System.out.println("Size of the LinkedList: " + size);
	}

	private Node insertAtFirst(Node list, int newValue) {
		Node newNode = new Node(newValue);
		if (list == null) {
			list = newNode;
			return list;
		}
		newNode.next = list;
		return newNode;
	}

	private static void printLinkedList(Node head) {
		Node currentNode = head;
		while (currentNode != null) {
			System.out.print(currentNode.data + " --> ");
			currentNode = currentNode.next;
		}
		System.out.println("NULL");
	}

	private static int length(Node head) {
		if (head == null) {
			return 0;
		}
		int size = 0;
		Node currenNode = head;
		while (currenNode != null) {
			currenNode = currenNode.next;
			size++;
		}
		return size;
	}

}
