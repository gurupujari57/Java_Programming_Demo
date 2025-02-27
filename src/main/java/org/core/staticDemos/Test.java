package org.core.staticDemos;

public class Test {
    static int a=10;
    static int b;
    static {
        System.out.println("Static Block inotialized : ");
        //Static block accesing only static members
        b=a*4;
    }

    public static void main(String[] args) {
        System.out.println("From main : ");
        System.out.println("Value of a : "+a);
        System.out.println("Value of b : "+b);
    }
}
