/**
 * 
 * 
 * Implement a Stack Data Structure specifically to store integer data using two Queues.
 * There should be two data members, both being Queues to store the data internally. You may use the inbuilt Queue.
 * 
 * Implement the following public functions :
 * 
 * 1. Constructor: It initializes the data members(queues) as required.
 * 
 * 2. push(data) : This function should take one argument of type integer. It pushes the element into the stack and returns nothing.
 * 
 * 3. pop() : It pops the element from the top of the stack and, in turn, returns the element being popped or deleted. In case the stack is empty, it returns -1.
 * 
 * 4. top : It returns the element being kept at the top of the stack. In case the stack is empty, it returns -1.
 * 
 * 5. size() : It returns the size of the stack at any given instance of time.
 * 
 * 6. isEmpty() : It returns a boolean value indicating whether the stack is empty or not.
 * 
 * Link: https://www.codingninjas.com/studio/problems/stack-using-queue_795152
 * 
 */
package com.dsa.stackqueues.easy;

import java.util.LinkedList;
import java.util.Queue;

class StackP3 {

	// Define the data members.
	Queue<Integer> q1;
	Queue<Integer> q2;
	int count = 0;

	public StackP3() {
		q1 = new LinkedList<Integer>();
		q2 = new LinkedList<Integer>();
	}

	/*----------------- Public Functions of Stack -----------------*/

	public int getSize() {
		return count;
	}

	public boolean isEmpty() {
		return count == 0;
	}

	public void push(int element) {
		q2.add(element);
		while (!q1.isEmpty()) {
			q2.add(q1.peek());
			q1.remove();
		}
		// swap queues q1 with q2
		Queue<Integer> q = q1;
		q1 = q2;
		q2 = q;
		count++;
	}

	public int pop() {
		if (q1.isEmpty()) {
			return -1;
		}
		count--;
		return q1.remove();
	}

	public int top() {
		if (q1.isEmpty()) {
			return -1;
		}
		return q1.peek();
	}
}

/**
 * 
 */
public class P3_Implement_Stack_Using_Two_Queues {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		StackP3 s = new StackP3();
		s.push(1);
		s.push(2);
		s.push(3);
		s.push(4);
		s.push(5);
		printQueue(s);
	}

	private static void printQueue(StackP3 s) {
		System.out.println("Is Stack empty: " + s.isEmpty());
		while (!s.isEmpty()) {
			System.out.println(s.pop());
		}
		System.out.println("Is Stack empty: " + s.isEmpty());
	}

}
