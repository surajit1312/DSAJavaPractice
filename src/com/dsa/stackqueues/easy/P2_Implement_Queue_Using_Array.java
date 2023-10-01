/**
 * Queue is a linear data structure that follows the idea of First In First Out. That means insertion and retrieval operations happen at opposite ends.
 * Implement a simple queue using arrays.
 * 
 * You are given 'query' queries which are either of the 2 types:
 * 1. Enqueue (add) element ‘e’ at the end of the queue.
 * 2. Dequeue (retrieve) the element from the front of the queue. If the queue is empty, return -1.
 * 
 * 
 * Link: https://www.codingninjas.com/studio/problems/implement-queue-using-arrays_8390825
 */
package com.dsa.stackqueues.easy;

class Queue {
	int front, rear;
	int[] arr;
	int capacity;
	int count = 0;

	Queue(int capacity) {
		front = 0;
		rear = 0;
		this.capacity = capacity;
		arr = new int[capacity];
	}

	// Enqueue (add) element 'e' at the end of the queue.
	public void enqueue(int e) {
		if (count >= capacity) {
			return;
		}
		arr[rear % capacity] = e;
		count++;
		rear++;
	}

	// Dequeue (retrieve) the element from the front of the queue.
	public int dequeue() {
		if (front == rear) {
			return -1;
		}
		int popped = arr[front % capacity];
		arr[front % capacity] = -1;
		front++;
		count--;
		return popped;
	}

	public int sizeOfQueue() {
		return count;
	}

	public boolean isEmpty() {
		return rear == front;
	}

	public boolean isFull() {
		return count == capacity;
	}
}

/**
 * 
 */
public class P2_Implement_Queue_Using_Array {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Queue q = new Queue(5);
		q.enqueue(1);
		q.enqueue(2);
		q.enqueue(3);
		q.enqueue(4);
		q.enqueue(5);
		q.enqueue(6);
		q.enqueue(7);
		printQueue(q);
		System.out.println("Is Queue full: " + q.isFull());
		System.out.println("Size of Queue: " + q.sizeOfQueue());
		System.out.println("Popped element: " + q.dequeue());
		System.out.println("Popped element: " + q.dequeue());
		printQueue(q);
		System.out.println("Is Queue full: " + q.isFull());
		System.out.println("Size of Queue: " + q.sizeOfQueue());
		System.out.println("Is Queue empty: " + q.isEmpty());
		System.out.println("Popped element: " + q.dequeue());
		System.out.println("Popped element: " + q.dequeue());
		System.out.println("Is Queue empty: " + q.isEmpty());

		System.out.println("Popped element: " + q.dequeue());
		System.out.println("Is Queue empty: " + q.isEmpty());
		System.out.println("Is Queue full: " + q.isFull());
	}

	private static void printQueue(Queue q) {
		for (int i = (q.front % q.capacity); i < q.rear; i++) {
			System.out.println(q.arr[i]);
		}
	}

}
