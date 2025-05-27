package org.dsa.linkList;
class DoublyLinearLinkedList{
    class Node{
        private int data;
        private Node next;
        private Node prev;

        public Node() {
        }

        public Node(int val) {
            data = val;
            next = null;
            prev = null;
        }
    }
    private Node head;

    public DoublyLinearLinkedList() {
        head = null;
    }

    public void display(){
        Node trav = head;
        System.out.println("List : ");
        while (trav != null){
            System.out.print(trav.data+"->");
            trav = trav.next;
        }
    }

    public void addLast(int val){
        Node newNode = new Node(val);
        if(head == null){
            head = newNode;
            newNode.prev = head;
        }else{
            Node trav = head;
            while (trav.next != null){
                trav = trav.next;
            }
            trav.next = newNode;
            newNode.prev = trav;
        }
    }
    public void addFirst(int val){
        Node newNode = new Node(val);
        newNode.next = head;
        head = newNode;
    }

    public void addAtpos(int val, int pos){
        if(head == null || pos<1){
            addFirst(val);
        }else {
            Node newNode = new Node(val);
            Node trav = head, temp = null;
            for(int i=1;i<pos-1;i++){
                if(trav.next==head)
                    break;
                trav = trav.next;
            }
            newNode.next = trav.next;
            trav.next = newNode;
            newNode.prev = trav;

        }
    }
}
public class DoublyLinearListMain {
    public static void main(String[] args) {
        DoublyLinearLinkedList list = new DoublyLinearLinkedList();
        list.addLast(11);
        list.addLast(22);
        list.addLast(33);
        list.addFirst(44);
        list.addFirst(55);
        list.addAtpos(66,6);
        list.display();
    }
}
