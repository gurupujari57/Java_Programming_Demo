package org.dsa.linkList;
class SiglyList{
    static class Node{
        private int data;
        private Node next;
        public Node() {
            next = null;
            data = 0;
        }

        public Node(int val) {
            data = val;
            next = null;
        }
    }
    private Node head;

    public SiglyList() {
        head = null;
    }
    void display(){
        System.out.println("List : ");
        Node trav=head;
        while (trav!=null){
            System.out.print(trav.data + "->");
            trav=trav.next;
        }
        System.out.println("");
    }
    void addLast(int val){
        Node nn= new Node(val);
        if(head==null){
            head=nn;
        }else {
            Node trav=head;
            while (trav.next!=null){
                trav=trav.next;
            }
            trav.next=nn;
        }
    }

    void reverselist(){
        Node oldhead=head;
        head=null;
        while (oldhead!=null){
            //delFirst
            Node temp=oldhead;
            oldhead=oldhead.next;

            //addFirst
            temp.next=head;
                head=temp;
        }
    }
}
public class ReverseLinkedListMain {
    public static void main(String[] args) {
        SiglyList list=new SiglyList();
        list.addLast(10);
        list.addLast(20);
        list.addLast(30);
        list.addLast(40);
        list.display();
        list.reverselist();
        list.display();
    }
}
