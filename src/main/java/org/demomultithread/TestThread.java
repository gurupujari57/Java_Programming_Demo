package org.demomultithread;


public class TestThread {
    public static void main(String[] args) {
        RunnableDemo runnableDemo = new RunnableDemo("Thread1");
        runnableDemo.start();

        RunnableDemo runnableDemo1=new RunnableDemo("Thread2");
        runnableDemo1.start();
    }
}

class RunnableDemo implements Runnable{
    private Thread t;
    private String threadName;

    public RunnableDemo(String threadName) {
        this.threadName = threadName;
        System.out.println("Creating ::"+ threadName);
    }

    @Override
    public void run() {
        System.out.println("Running ::"+threadName);
        try{
            for(int i=4; i>0;i--){
                System.out.println(threadName +"," + i);
                Thread.sleep(5000);
            }
        } catch (InterruptedException e) {
            System.out.println("Thread " +  threadName + " interrupted.");
        }
        System.out.println("Thread " +  threadName + " exiting.");
    }

    public void start(){
        System.out.println("Starting :: "+threadName);
        if(t==null){
            t=new Thread(this, threadName);
            t.start();
        }
    }
}