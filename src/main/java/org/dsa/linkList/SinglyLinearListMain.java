package org.dsa.linkList;
class SinlyLinearList{
    static class Node{
        private int data;
        private Node next;

        public Node() {
            data=0;
            next=null;
        }

        public Node(int val) {
            data = val;
            next = null;
        }
    }
    private Node head;

    public SinlyLinearList() {
        head = null;
    }

    public void display(){
        Node trav = head;
        while (trav!=null){
            System.out.print(trav.data+"->");
            trav = trav.next;
        }
    }
    public void addLast(int val){
        Node trav = head;
        Node newNode = new Node(val);
        if(trav == null)
            head = newNode;
        else {
            while (trav.next!=null){
                trav = trav.next;
            }
            trav.next = newNode;
        }
    }
    public void addFirst(int val){
        Node newNode = new Node(val);
            newNode.next = head;
            head = newNode;

    }
    public void delLast(){
        Node trav = head;
        if(trav ==  null)
            throw new RuntimeException("");
        if(head.next == null)
            head=null;
        while (trav.next.next != null){
            trav = trav.next;
        }
        trav.next =null;
    }
    public void delFirst(){
        Node trav = head;
        if(trav ==  null)
            throw new RuntimeException("");
        if(head.next == null)
            head=null;
        head = head.next;
    }

    public void delAtPos(int pos){
        if (pos==1)
            delFirst();
        if(head==null || pos<1)
            throw new RuntimeException("");
        Node temp=null, trav=head;
        for (int i=1;i<pos;i++){
            if(trav==null)
                throw  new RuntimeException("");
            temp = trav;
            trav=trav.next;
        }
        temp.next = trav.next;
    }
}
public class SinglyLinearListMain {
    public static void main(String[] args) {
        SinlyLinearList list = new SinlyLinearList();
//        list.addLast(11);
//        list.addLast(22);
//        list.addLast(33);
//        list.display();
        list.addFirst(44);
        list.addFirst(55);
//        list.delLast();
//        list.delFirst();
        list.display();
//        list.delAtPos(2);
//        System.out.println();
//        list.display();
    }

}
