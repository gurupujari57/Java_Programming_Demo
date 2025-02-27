package org.dsa.stackqueue;

import java.util.Stack;
import java.util.stream.Collectors;

public class StackApplication {
    public static void main(String[] args) {

        //Parentheses Balance
    /*    String str="{[()]}";
        if(isBalanced(str)){
            System.out.println(str +" :: is Balanced");
        }else {
            System.out.println(str +" :: is not Balanced");

        }*/

   /*     //Queue using stack
        int []num={1,2,3};
        queuefromStack(num);*/


        //Queue using stack
        QueueUsingStack queue=new QueueUsingStack();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        System.out.println(queue.dequeue()); // 1
        System.out.println(queue.peek());    // 2
        System.out.println(queue.dequeue()); // 2
        System.out.println(queue.dequeue()); // 3


    }

  /*  static boolean isBalanced(String str){
        Stack<Character> stack=new Stack<>();
        for (int i=0;i<str.length();i++){
            char currentChar=str.charAt(i);

            if(currentChar=='(' || currentChar=='{' || currentChar=='['){
                stack.push(currentChar);
            }else if (currentChar==')' || currentChar=='}' || currentChar==']'){
                if(stack.empty())
                    return false;
                char top=stack.pop();
                if((top=='(' && currentChar!=')') ||
                (top=='{' && currentChar!='}') ||
                (top=='[' && currentChar!=']')){
                    return false;
                }
            }
        }
        return stack.empty();
    }*/
    
    
    //concise code 
    
    static boolean isBalanced(String str){
        Stack<Character> stack=new Stack<>();
        for (char currentChar : str.toCharArray()){
            if(currentChar=='(' || currentChar=='{' || currentChar=='['){
                stack.push(currentChar);
            } else if (currentChar==')'&&(stack.empty()||stack.pop()!='(')||
                    currentChar==']'&&(stack.empty()||stack.pop()!='[') ||
                    currentChar=='}'&&(stack.empty()||stack.pop()!='{')) {
                return false;
            }
        }
        return stack.empty();
    }

   /* static void queuefromStack(int []num){
        Stack<Integer> stack1=new Stack<>();
        Stack<Integer> stack2=new Stack<>();

        for (Integer integer:num){
            stack1.push(integer);
        }
        while (!stack1.empty()){
            stack2.push(stack1.pop());
        }
        while (!stack2.empty()){
            System.out.println(stack2.pop());
        }
    }*/

    static class QueueUsingStack{
        Stack<Integer> stack1=new Stack<>();
        Stack<Integer> stack2=new Stack<>();

        void enqueue(int val){
            stack1.push(val);
        }
        int dequeue(){
        if(stack2.isEmpty()){
            while (!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
        if(stack2.isEmpty())throw new IllegalStateException("Queue is Empty");
        return stack2.pop();
        }

        int peek(){
            if(stack2.isEmpty()){
                while (!stack1.isEmpty()){
                    stack2.push(stack1.pop());
            }
        }
         if(stack2.isEmpty())throw new IllegalStateException("Queue is Empty");
         return stack2.peek();
    }

    boolean isEmpty(){
        return stack1.isEmpty() && stack2.isEmpty();
        }
    }

}
