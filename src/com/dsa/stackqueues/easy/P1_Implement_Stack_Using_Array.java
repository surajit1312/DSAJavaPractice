/**
 * 
 * Stack is a data structure that follows the LIFO (Last in First out) principle. Design and implement a stack to implement the following functions:
 * 
 * 1. Push(num): Push the given number in the stack if the stack is not full.
 * 2. Pop: Remove and print the top element from the stack if present, else print -1.
 * 3. Top: Print the top element of the stack if present, else print -1.
 * 4. isEmpty: Print 1 if the stack is empty, else print 0.
 * 5. isFull: Print 1 if the stack is full, else print 0.
 * 
 * Link: https://www.codingninjas.com/studio/problems/stack-implementation-using-array_3210209
 * 
 */
package com.dsa.stackqueues.easy;

class StackP1 {
	int[] arr;
	int top = -1;
	int capacity = 0;

	StackP1(int capacity) {
		this.capacity = capacity;
		arr = new int[capacity];
		top = -1;
	}

	public void push(int num) {
		if (isFull() == 0) {
			arr[++top] = num;
		}
	}

	public int pop() {
		if (isEmpty() == 1) {
			return -1;
		}
		int last = arr[top];
		arr[top] = -1;
		top -= 1;
		return last;
	}

	public int top() {
		if (top < 0) {
			return -1;
		}
		return arr[top];
	}

	public int isEmpty() {
		return (top == -1) ? 1 : 0;
	}

	public int isFull() {
		return (top + 1 == capacity) ? 1 : 0;
	}
}

/**
 * 
 */
public class P1_Implement_Stack_Using_Array {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		StackP1 s = new StackP1(2);
		s.push(1);
		s.push(2);
		printStack(s);

		System.out.println("Removed top element from Stack: " + s.pop());
		System.out.println("Top element from Stack: " + s.top());
		System.out.println("Is Stack Empty: " + s.isEmpty());
		System.out.println("Is Stack Full: " + s.isFull());
	}

	private static void printStack(StackP1 s) {
		for (int i = s.arr.length - 1; i >= 0; i--) {
			System.out.println(s.arr[i]);
		}
	}

}
