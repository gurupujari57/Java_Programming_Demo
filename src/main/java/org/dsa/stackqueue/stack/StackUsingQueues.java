package org.dsa.stackqueue.stack;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueues {
    Queue<Integer> q1 = new LinkedList<>();
    Queue<Integer> q2 = new LinkedList<>();

    public void push(int num){
        //Enqueu to q2
        q2.add(num);

        //move all elements from q1 to q2
        while (!q1.isEmpty()){
            q2.add(q1.poll());
        }
        //swap q1 and q2
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
    }

    public int pop(){
        if(q1.isEmpty()){
            throw new RuntimeException("Queue is Empty ");
        }
        return q1.poll();
    }
    public int top(){
        if(q1.isEmpty()){
            throw new RuntimeException("Queue is Empty ");
        }
        return q1.peek();
    }
    public static void main(String[] args) {
        StackUsingQueues stackUsingQueues = new StackUsingQueues();
        stackUsingQueues.push(10);
        stackUsingQueues.push(20);
        stackUsingQueues.push(30);
        System.out.println(stackUsingQueues.top());
        System.out.println(stackUsingQueues.pop());
        System.out.println(stackUsingQueues.top());

    }
}
