package org.recursion;

public class PrintN {
    public static void main(String[] args) {
        recursiveNum(5);
    }

    public static void recursiveNum(int num){
        if(num==0)
            return;
        System.out.println(num);
        recursiveNum(num-1);
    }
}
