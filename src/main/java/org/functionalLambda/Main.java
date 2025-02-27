package org.functionalLambda;

public class Main {
    public static void main(String[] args) {
        //Create class and call abstract method
//        MyInter myInter = new MyInterImpl();
//        myInter.sayHello();

        //Anonymous class
  /*      MyInter m = new MyInter() {
            @Override
            public void sayHello() {
                System.out.println("This is first anonymous class");
            }
        };
        m.sayHello();*/

        //using our interface with the help of lamda
        myInter i=()->{
            System.out.println("This is first lamda execution");
        };
        i.sayHello();


      /*  sumInter s=(int a, int b)->{
            return a+b;
        };*/
        sumInter s=(a, b)->a+b;


        System.out.println("Sum is :: "+s.sum(2,3));

        lengthInter lengthInter=(str -> str.length());

        System.out.println("Length :: "+lengthInter.getLength("Hello"));
    }

}
