package org.dsa.stackqueue.queue;

public class QueueImplArrays {
    // Size of the queue
    static int size = 10;
    static int[] q = new int[size];
    // Variables to manage the queue
    static int currentSize = 0, start = -1, end = -1;

    public static void main(String[] args) {
        push(10);
        push(20);
        push(30);

        int front = top();  // Get the front element
        System.out.println("Front element: " + front);

        // Pop an element and show it
        pop();
        System.out.println("Front element after pop: " + top());

        // Show the current size of the queue
        System.out.println("Current size of the queue: " + size());
    }

    // Push element into the queue
    public static void push(int x) {
        if (currentSize == size) {
            System.out.println("Queue is full, cannot add element");
            return;
        }

        // If the queue is empty, initialize start and end
        if (currentSize == 0) {
            start = 0;
            end = 0;
        } else {
            // Circular increment of end
            end = (end + 1) % size;
        }

        q[end] = x;  // Add element at the end
        currentSize++;  // Increment the current size
    }

    // Pop an element from the queue (remove from the front)
    public static int pop() {
        if (currentSize == 0) {
            System.out.println("Queue is empty, cannot pop");
            return -1;
        }

        int element = q[start];  // Get the front element

        if (currentSize == 1) {
            // Reset queue to empty
            start = -1;
            end = -1;
        } else {
            // Circular increment of start
            start = (start + 1) % size;
        }

        currentSize--;  // Decrement the current size
        return element;  // Return the popped element
    }

    // Get the front element of the queue (peek)
    public static int top() {
        if (currentSize == 0) {
            return -1;  // Return -1 if the queue is empty
        }
        return q[start];  // Return the front element
    }

    // Get the current size of the queue
    public static int size() {
        return currentSize;  // Return the number of elements in the queue
    }
}
