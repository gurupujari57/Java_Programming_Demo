package org.dsa.linkList;

import java.util.Scanner;
class DoublyCircular{
    class Node{
        private int data;
        private Node next;
        private Node prev;

        public Node() {
            next = null;
            prev = null;
            data = 0;
        }

        public Node(int val) {
            data = val;
            next = null;
            prev = null;
        }
    }
    private Node head;

    public DoublyCircular() {
        this.head = null;
    }
    public boolean isEmpty(){
        return head==null;
    }
    public void displayForward() {
        System.out.println("Fwd List :: ");
        if (isEmpty()) {
            System.out.println("List is empty.");
            return;
        }
        Node trav = head;
        do {
            System.out.print(trav.data + " -> ");
            trav = trav.next;
        } while (trav != head);
        System.out.println();
    }
    public void displayReverse(){
        System.out.println("Rev List :: ");
        if (isEmpty()) {
            System.out.println("List is empty.");
            return;
        }
        Node trav = head.prev;
        do{
            System.out.print(trav.data + " -> ");
            trav = trav.prev;
        }while (trav != head.prev);
        System.out.println();
    }
    public void addLast(int val){
        Node newNode  = new Node(val);
        if(isEmpty()){
            head = newNode;
            head.next = head;
            head.prev = head;
        }else {
            Node trav = head;
            while (trav.next != head){
                trav = trav.next;
            }
            trav.next = newNode;
            newNode.prev = trav;
            newNode.next = head;
            head.prev = newNode;
        }
    }

    public void addFirst(int val){
        Node newNode = new Node(val);
        if(isEmpty()){
            head = newNode;
            newNode.next = head;
            newNode.prev = head;
        }else {
            Node trav = head;
            while (trav.next != head){
                trav = trav.next;
            }
            newNode.next = head;
            newNode.prev = trav;
            trav.next = newNode;
            head.prev = newNode;
        }
    }

}
public class DoublyCircularListmain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        int val=0;
        DoublyCircular list = new DoublyCircular();
        do{
            System.out.println("0.Exit 1.Display 2.addLast 3.addFirst 4.addAtPos 5.delFirst 6.delLast 7.RevDisplay");
            choice = scanner.nextInt();
            switch (choice){
                case 1://Display the List
                    list.displayForward();
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
             /*   case 4://addAtPos
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
                    break;*/
                case 7: //RevDisplay
                    list.displayReverse();
                    break;
            }
        }while (choice != 0);
        scanner.close();
    }
}
