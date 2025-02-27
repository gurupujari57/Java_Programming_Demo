package org.dsa.linkList;

import java.util.Scanner;

class SinglyCircular{
    static class Node{
        private Node next;
        private int data;

        public Node() {
            next = null;
            data = 0;
        }

        public Node(int val) {
            this.data = val;
            this.next = null;
        }
    }
    private Node head;

    public SinglyCircular() {
        this.head = null;
    }

    public boolean isEmpty(){
        return head==null;
    }
    void display(){
        System.out.println("List : ");
        Node trav=head;
        if(isEmpty()){
            return;
        }
        do{
            System.out.println(trav.data);
            trav=trav.next;
        }while (trav != head);
    }
    void addLast(int val){
        Node newnode = new Node(val);
        if(isEmpty()){
            head = newnode;
            newnode.next = head;
        }else {
            Node trav=head;
            while (trav.next != head){
                trav=trav.next;
            }
            newnode.next=head;
            trav.next=newnode;
        }
    }

    void addFirst(int val){
        Node newNode = new Node(val);
        if(isEmpty()){
            head=newNode;
            newNode.next=head;
        }else {
            Node trav = head;
            while (trav.next!=head){
                trav=trav.next;
            }
            newNode.next=head;
            trav.next=newNode;
            head=newNode;
        }
    }

    void addAtpos(int val, int pos){
        Node newNode = new Node(val);
        if(isEmpty()){
            if(head==null || pos<=1)
                addFirst(val);
        }else {
            Node trav=head;
            for (int i=0;i<pos-1;i++){
                //Add Node at end
                if(trav.next==head)
                    break;
                trav=trav.next;
            }
            newNode.next=trav.next;
            trav.next=newNode;
        }
    }
    void delFirst(){
        if(isEmpty()){
            throw new RuntimeException("Lis is Empty : ");
        }
        //If list has single Node
        if(head.next==head){
            head=null;
        }else {
            Node trav=head;
            while (trav.next != head){
                trav=trav.next;
            }
            head=head.next;
            trav.next=head;
        }
    }

    void delLast(){
        if(isEmpty()){
            throw new RuntimeException("Lis is Empty : ");
        }
        if(head.next==head){
            head=null;
        }else {
            Node trav = head;
            while (trav.next.next != head){
                trav=trav.next;
            }
            trav.next=head;
        }

    }
}

public class SinglyCircularListMain {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        int val=0;
        SinglyCircular list = new SinglyCircular();
        do{
            System.out.println("0.Exit 1.Display 2.addLast 3.addFirst 4.addAtPos 5.delFirst 6.delLast");
            choice = scanner.nextInt();
            switch (choice){
                case 1://Display the List
                    list.display();
                    break;
                case 2://addLast
                    System.out.println("Enter the Element : ");
                    val = scanner.nextInt();
                    list.addLast(val);
                    break;
                case 3://addFirst
                    System.out.println("Enter the Element : ");
                    val = scanner.nextInt();
                    list.addFirst(val);
                    break;
                case 4://addAtPos
                    System.out.println("Enter the Element : ");
                    val = scanner.nextInt();
                    System.out.println("Enter the Position : ");
                    int pos = scanner.nextInt();
                    list.addAtpos(val,pos);
                    break;
                case 5://delFirst
                    list.delFirst();
                    break;
                case 6://delLast
                    list.delLast();
                    break;
            }
        }while (choice != 0);
        scanner.close();
    }
}
