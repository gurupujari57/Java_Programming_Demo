package org.treeDS;


import java.util.Scanner;

class Node{
    int data;
    Node left;
    Node right;

    public Node(int d) {
        data = d;
        right=left=null;
    }

}
//PreOrder
public class BinaryTree {

    public static void main(String[] args) {
        display();
    }
   static Node root;
    static Node createTree(Scanner sc){
        int data=sc.nextInt();

        //base case
        if(data==-1){
            return null;
        }

        //recursive case
        Node n=new Node(data);
        n.left=createTree(sc);
        n.right=createTree(sc);
        return n;
    }
   static void display(){
       Scanner sc=new Scanner(System.in);
       root=createTree(sc);
       System.out.println();

       System.out.print("PreorderPrint :: ");
        preorderPrint(root);
       System.out.println();
       System.out.print("InOrderPrint :: ");
       inoderPrint(root);
       System.out.println();
       System.out.print("Postorderprint :: ");
       postOrderprint(root);
    }
   static void preorderPrint(Node root){
        //base case
        if(root==null)
            return;
        System.out.print(root.data+" ");
        preorderPrint(root.left);
        preorderPrint(root.right);

    }

    static void inoderPrint(Node root){
        if(root==null){
            return;
        }
        inoderPrint(root.left);
        System.out.print(root.data+" ");
        inoderPrint(root.right);
    }
    static void postOrderprint(Node root){
        if(root==null)
            return;
        postOrderprint(root.left);
        postOrderprint(root.right);
        System.out.print(root.data+" ");
    }
}
