package org.functionalLambda;

public class ThreadDemo {
    public static void main(String[] args) {
        //First Thread
        Runnable thread1=()->{
            //this is body of thread
            for(int i=1;i<=10;i++){
                System.out.println("Value of i is ::"+i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        Thread t=new Thread(thread1);
        t.setName("ABC");
        t.start();

    }
}
