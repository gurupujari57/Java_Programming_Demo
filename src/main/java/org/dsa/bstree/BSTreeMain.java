package org.dsa.bstree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

class BinarySearch{
    static class Node{
        private int data;
        private Node left;
        private Node right;

        public int getData() {
            return data;
        }


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
        System.out.println("IN :: ");
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
        System.out.println("PRE :: ");
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
        System.out.println("POST :: ");
        postorder(root);
    }

    public void deleteAll(Node trav){
        if (trav==null)
            return;
        deleteAll(trav.left);
        deleteAll(trav.right);
        trav.left = null;
        trav.right = null;
        trav = null;
    }
    public void deleteAll(){
        deleteAll(root);
        root = null;
    }

    public int height(Node trav){
        if(trav == null)
            return -1;
        int hl = height(trav.left);
        int hr = height(trav.right);
        int max = hl>hr? hl : hr;
        return max+1;
    }
    public int height(){
        return height(root);
    }

    //Breadth First Search (BFS)
    public Node bfs(int key){
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()){
            Node trav = q.poll();
            if (key == trav.data)
                return trav;
            if (trav.left != null)
                q.offer(trav.left);
            if (trav.right != null)
                q.offer(trav.right);
        }
        return null;
    }

    public Node dfs(int key){
        Stack<Node> s = new Stack<>();
        s.push(root);
        while (!s.isEmpty()){
            Node trav = s.pop();
            if(key == trav.data)
                return trav;
            if(trav.right != null)
                s.push(trav.right);
            if(trav.left != null)
                s.push(trav.left);
        }
        return null;
    }

    public Node binarySearch(int key){
        Node trav = root;
      while (trav != null){
          if (trav.data == key)
              return trav;
          if (key< trav.data)
              trav = trav.left;
          else
              trav = trav.right;
      }
      return null;
    }
    public Node binarySearchRecursive(Node trav, int key){
        if(trav == null)
            return null;
            if (trav.data == key)
                return trav;
            if (key < trav.data)
              return   binarySearchRecursive(trav.left, key);
            else
                return binarySearchRecursive(trav.right, key);
    }
    public Node binarySearchRecursive(int key){
        return binarySearchRecursive(root, key);
    }
    public Node[] binarySearchParent(int key){
        Node parent = null; Node trav = root;

      while (trav != null){
          if (trav.data == key)
              return new Node[]{trav, parent};
          parent = trav;
          if(key < trav.data){
              trav = trav.left;
          }else {
              trav = trav.right;
          }
      }
        return new Node[]{null, null};
    }
     public void deleteNode(int key){
        Node trav, parent;
        //find the node to be deleted along with its parent
         Node[] arr = binarySearchParent(key);
         trav = arr[0];
         parent = arr[1];
         //if node is not found throw exception
         if (trav == null)
             throw new RuntimeException("Node not found : ");
         //if node has left as well as right child
         if(trav.left != null && trav.right != null){
             //find its successor with its parent
             Node succe = trav.right;
             while (succe.left != null){
                 parent = succe;
                 succe = succe.left;
             }
             //overrite data of node with successor data
             trav.data = succe.data;
             //mark successor node to be deleted
             trav = succe;
         }
         //if node has right child (or node doen't have left child)
         if(trav.left == null){
             if(trav == root)
                 root = trav.right;
             else if (trav == parent.left)
                 parent.left = trav.right;
             else
                 parent.right = trav.right;
         }
         //if node has left child (or node doesn't have right child)
         else if (trav.right == null) {
             if(trav == root)
                 root = trav.left;
             else if (trav == parent.left)
                 parent.left = trav.left;
             else
                 parent.right = trav.left;
         }
     }
}
public class BSTreeMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
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

        //In-oreder traversal
        bs.inorder();
        System.out.println();

        //Pre-order traversal
        bs.preorder();
        System.out.println();

        //Post-order traversal
        bs.postorder();
        System.out.println();

        //DeleteAll node
//        bs.deleteAll();

        //Height of node
        int height = bs.height();
        System.out.println("Height : "+height);


        System.out.println("Enter the element to find : ");
        int key = sc.nextInt();

        //BFS Algorithm (levelwise Algorithm)
        BinarySearch.Node temp = bs.bfs(key);
        if (temp != null)
            System.out.println("Found :"+key);
        else
            System.out.println("Not Found :"+key);

        //DFS Algorithm
        BinarySearch.Node tempDfs = bs.dfs(key);
        if (tempDfs != null)
            System.out.println("Found :"+key);
        else
            System.out.println("Not Found :"+key);

        //BS Alforithm
        BinarySearch.Node tempBst = bs.binarySearch(key);
        if (tempBst != null)
            System.out.println("Found :"+key);
        else
            System.out.println("Not Found :"+key);

        //BS recursive Algorithm
        BinarySearch.Node tempBstRec = bs.binarySearchRecursive(key);
        if (tempBstRec != null)
            System.out.println("Found :"+key);
        else
            System.out.println("Not Found :"+key);

        //BS with Parent node
        BinarySearch.Node[] arr = bs.binarySearchParent(key);
        if(arr[0] == null)
            System.out.println("BS: Not found.");
        else if(arr[1] == null) // root node found
            System.out.println("BS: Found: " + arr[0].getData() + " with Parent: " + arr[1]);
        else // node found with parent
            System.out.println("BS: Found: " + arr[0].getData() + " with Parent: " + arr[1].getData());

        //DeleteNode
        System.out.println("Enter element node to delete : ");
        int node  = sc.nextInt();
        bs.deleteNode(node);
        bs.inorder();
    }

}

