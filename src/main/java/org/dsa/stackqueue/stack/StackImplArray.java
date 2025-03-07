package org.dsa.stackqueue.stack;

public class StackImplArray {
    // Declare a static array and top pointer
    static int top = -1;
    static int[] stack = new int[10];

    public static void main(String[] args) {
        // Push elements into the stack
        push(10);
        push(20);
        push(30);

        // Print the top element of the stack
        int res = top();
        System.out.println("Top element: " + res);

        // Pop elements from the stack
        pop();
        System.out.println("Top element after pop: " + top());

        int size = size();
        System.out.println(size);
    }

    // Push element into the stack
    public static void push(int x) {
        if (top < 9) {  // Check if there is space in the stack
            top += 1;
            stack[top] = x;
        } else {
            System.out.println("Stack overflow");
        }
    }

    // Return the top element of the stack
    public static int top() {
        if (top == -1) {
            return -1;  // Stack is empty
        }
        return stack[top];
    }

    // Pop element from the stack
    public static void pop() {
        if (top == -1) {
            System.out.println("Stack is empty");
            return;
        }
        top -= 1;
    }

    // Return the size of the stack
    public static int size() {
        return top + 1;
    }
}
