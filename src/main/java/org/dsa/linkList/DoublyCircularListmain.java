package org.dsa.linkList;

import java.util.Scanner;

public class DoublyCircularListmain {
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
