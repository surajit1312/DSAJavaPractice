/**
 * 
 */
package com.dsa.linkedlist.easy;

/****************************************************************

Following is the class structure of the Node class:

class Node {
    public int data;
    public Node next;
    public Node prev;

    Node()
    {
        this.data = 0;
        this.next = null;
        this.prev = null;
    }

    Node(int data)
    {
        this.data = data;
        this.next = null;
        this.prev = null;
    }

    Node(int data, Node next)
    {
        this.data = data;
        this.next = next;
        this.prev = next;
    }
};

****************************************************************/

/**
 * 
 * You are given the head of a linked list 'list' of size 'n' and an integer
 * 'newValue' Your task is to insert a node with the value ‘newValue’ at the
 * beginning of the ‘list’ and return the new head of the linked list.
 * 
 * You must write an algorithm whose time complexity is O(1) and whose space
 * complexity is O(1)
 * 
 * Note: In the output, you will see the elements of the linked list made by
 * you.
 * 
 * Input: ‘N’ = 4, ‘newValue’ = 0 ‘list’ = 4 -> 2 -> 5 -> 1
 * 
 * Output: 0 4 2 5 1
 * 
 * Explanation:
 * 
 * Linked List after inserting the newValue is 0 -> 4 -> 2 -> 5 -> 1
 * 
 */
public class P2_Add_Node_To_First {

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

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		P2_Add_Node_To_First list = new P2_Add_Node_To_First();
		Node node = list.insertAtFirst(null, 1);
		node = list.insertAtFirst(node, 5);
		node = list.insertAtFirst(node, 2);
		node = list.insertAtFirst(node, 4);
		node = list.insertAtFirst(node, 0);
		printLinkedList(node);
	}

}
