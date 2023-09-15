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
};

*****************************************************************/

/**
 * 
 * You are given the head of a linked list 'list' of size 'N' Your task is to
 * delete the linked list's last node and return the linked list's head.
 * 
 * Input: ‘N’ = 4, ‘list’ = 4 -> 2 -> 5 -> 1
 * 
 * Output: 4 2 5
 * 
 * Explanation: After deleting the last node, the Linked List is 4 -> 2 -> 5.
 * 
 * Link:
 * https://www.codingninjas.com/studio/problems/delete-node-of-linked-list_8160463
 */
public class P3_Delete_Node_Last {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		P3_Delete_Node_Last list = new P3_Delete_Node_Last();
		Node node = list.insertAtFirst(null, 1);
		node = list.insertAtFirst(node, 5);
		node = list.insertAtFirst(node, 2);
		node = list.insertAtFirst(node, 4);
		node = list.insertAtFirst(node, 0);
		System.out.println("Before delete");
		printLinkedList(node);
		deleteLast(node);
		System.out.println("After delete");
		printLinkedList(node);
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

	private static Node deleteLast(Node list) {
		if (list == null || list.next == null) {
			return null;
		}
		Node currentNode = list;
		Node secondLastNode = null;
		while (currentNode.next != null) {
			secondLastNode = currentNode;
			currentNode = currentNode.next;
		}
		secondLastNode.next = null;
		return list;
	}

}
