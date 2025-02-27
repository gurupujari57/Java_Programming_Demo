package org.dsa.stackqueue;

import java.util.LinkedList;
import java.util.Queue;

class StackUsingQueue{
    Queue<Integer> queue1;
    Queue<Integer> queue2;

    public StackUsingQueue() {
        queue1=new LinkedList<>();
        queue2=new LinkedList<>();
    }
    void push(int val){
        queue1.add(val);
    }
    int pop() throws Exception {
        if(queue1.isEmpty()){
            throw new Exception("Queue is Empty");
        }
        while (queue1.size()>1){
            queue2.add(queue1.remove());
        }

        // The last remaining element in queue1 is the top of the
        int popTopElement=queue1.remove();

        //swap Qi and Q2
        Queue<Integer>temp=queue1;
        queue1=queue2;
        queue2=temp;
        return popTopElement;
    }
    // Top operation (peek)
    public int top() throws Exception {
        if (queue1.isEmpty()) {
            throw new Exception("Stack is empty");
        }

        // Move all elements except the last one from queue1 to queue2
        while (queue1.size() > 1) {
            queue2.add(queue1.remove());
        }

        // The last remaining element is the top of the stack
        int topElement = queue1.remove();
        queue2.add(topElement); // Push it back to queue2 to maintain the state

        // Swap queue1 and queue2
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;

        return topElement;
    }
}
public class QueueAppMain {
    public static void main(String[] args) {
        try {
            StackUsingQueue stack = new StackUsingQueue();
            stack.push(10);
            stack.push(20);
            stack.push(30);

            System.out.println("Top element: " + stack.top()); // Output: 30
            System.out.println("Popped: " + stack.pop()); // Output: 30
            System.out.println("Top element: " + stack.top()); // Output: 20
            stack.push(40);
            System.out.println("Popped: " + stack.pop()); // Output: 40
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
