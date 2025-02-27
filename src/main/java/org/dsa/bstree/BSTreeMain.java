package org.dsa.bstree;

class BinarySearch{
    static class Node{
        private int data;
        private Node left;
        private Node right;

        public Node() {
            data=0;
            left=null;
            right=null;
        }

        public Node(int val) {
            data = val;
            left=null;
            right=null;
        }
    }
    private Node root;

    public BinarySearch() {
       root = null;
    }

    public void add(int val){
        Node newNode  = new Node(val);
        if(root==null){
            root = newNode;
        }else {
            Node trav = root;
            while (true){
                if (val<trav.data){
                    if(trav.left!=null){
                        trav=trav.left;
                    }else {
                        trav.left = newNode;
                        break;
                    }
                }else {
                    if(trav.right!=null){
                        trav=trav.right;
                    }else {
                        trav.right = newNode;
                        break;
                    }
                }
            }
        }
    }

    public void inorder(Node trav){
        if(trav==null)
            return;
        inorder(trav.left);
        System.out.print(trav.data+", ");
        inorder(trav.right);
    }
    public void inorder(){
        inorder(root);
    }

    public void preorder(Node trav){
        if(trav==null)
            return;
        System.out.print(trav.data+", ");
        preorder(trav.left);
        preorder(trav.right);
    }
    void preorder(){
        preorder(root);
    }

    public void postorder(Node trav){
        if(trav==null)
            return;
        postorder(trav.left);
        postorder(trav.right);
        System.out.print(trav.data+", ");
    }
    void postorder(){
        postorder(root);
    }
}
public class BSTreeMain {
    public static void main(String[] args) {
        BinarySearch bs = new BinarySearch();
        bs.add(50);
        bs.add(30);
        bs.add(10);
        bs.add(40);
        bs.add(20);
        bs.add(70);
        bs.add(60);
        bs.add(90);
        bs.add(80);
        bs.add(100);
        System.out.println("IN :: ");
        bs.inorder();
        System.out.println();
        System.out.println("PRE :: ");
        bs.preorder();
        System.out.println();
        System.out.println("POST :: ");
        bs.postorder();
    }
}

