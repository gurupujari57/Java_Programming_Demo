package org.dsa.stackqueue;

import java.util.Stack;

//Implement Queue using Stack
class QueueUsingStack {
    Stack<Integer> stack1;
    Stack<Integer> stack2;

    public QueueUsingStack() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }
    void enQueue(int val){
        stack1.push(val);
    }
    int deQueue(){
        if(stack1.empty() && stack2.empty()){
            throw new RuntimeException("Stacks are Empty");
        }
        if (stack2.empty()){
            while (!stack1.empty()){
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }



    // Method to get the front element of the queue without removing it
    public int peek() throws Exception {
        if (stack1.isEmpty() && stack2.isEmpty()) {
            throw new Exception("Queue is empty");
        }

        // If stack2 is empty, move elements from stack1 to stack2
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }

        return stack2.peek(); // Return the top of stack2 as the front of the queue
    }

}
public class StackAppMain {

    public static void main(String[] args) {

        try {
            QueueUsingStack queue = new QueueUsingStack();
            queue.enQueue(10);
            queue.enQueue(20);
            queue.enQueue(30);

            System.out.println("Dequeued: " + queue.deQueue()); // Output: 10
            System.out.println("Front element: " + queue.peek()); // Output: 20
            queue.enQueue(40);
            System.out.println("Dequeued: " + queue.deQueue()); // Output: 20
            System.out.println("Dequeued: " + queue.deQueue()); // Output: 30
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
