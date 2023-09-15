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
 * You are given a Singly Linked List of integers with a head pointer. Every
 * node of the Linked List has a value written on it. Now you have been given an
 * integer value, 'K'.
 * 
 * Your task is to check whether a node with a value equal to 'K' exists in the
 * given linked list. Return 1 if node exists else return 0.
 * 
 * Link:
 * https://www.codingninjas.com/studio/problems/search-in-a-linked-list_975381
 * 
 */
public class P5_Search_Element_LinkedList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		P5_Search_Element_LinkedList list = new P5_Search_Element_LinkedList();
		Node node = list.insertAtFirst(null, 1);
		node = list.insertAtFirst(node, -1);
		node = list.insertAtFirst(node, 9);
		node = list.insertAtFirst(node, 7);
		node = list.insertAtFirst(node, 2);
		node = list.insertAtFirst(node, 6);
		node = list.insertAtFirst(node, 3);
		printLinkedList(node);
		int k = 2;
		int searchIndex = searchInLinkedList(node, k);
		System.out.println("Index of " + k + " in the LinkedList is : " + searchIndex);
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

	private static int searchInLinkedList(Node head, int k) {
		if (head == null) {
			return 0;
		}
		Node currentNode = head;
		while (currentNode != null) {
			if (currentNode.data == k) {
				return 1;
			}
			currentNode = currentNode.next;
		}
		return 0;
	}

}
