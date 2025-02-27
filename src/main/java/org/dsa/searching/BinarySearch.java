package org.dsa.searching;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class BinarySearch {
    public static void main(String[] args) throws Exception {
        int arr[] ={22,33,44,88,99,66};
        System.out.println("List of element : "+ Arrays.toString(arr));
        System.out.println("Enter the element to search : ");
        Scanner sc=new Scanner(System.in);
        int numToFind=sc.nextInt();

        //BinarySearch
        int num=binarySearchElement(arr, numToFind);

        System.out.println("The number will find at index : "+num);
    }

    public static int binarySearchElement( int [] arr, int numtofind) throws Exception {
        int low=0;
        int high=arr.length-1;
       try{
           while (low<=high){
               int mid=low + (high - low)/2;
               if(arr[mid] == numtofind){
                   return mid;
               }

               if (arr[mid]<numtofind){
                   low=mid+1;
               }else {
                   high=mid-1;
               }
           }
       }catch (Exception e){
           throw new InvalidParameterException();
       }
        return -1;
    }
}
