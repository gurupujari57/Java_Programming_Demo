package org.demomultithread;

class Runnablethread implements Runnable{
    Thread thread;
    String threadname;

    public Runnablethread(String threadname) {
        System.out.println("Creating ::"+ threadname);
        this.threadname = threadname;
    }

    @Override
    public void run() {
        System.out.println("Running ::"+ threadname);
        try {
            for (int i=5;i>0;i--){
                System.out.println(threadname + 1);
                System.out.println("Thread ::"+threadname);
                Thread.sleep(5000);
            }
        } catch (InterruptedException e) {
            System.out.println("Thread " + threadname + "interrupted");
        }
        System.out.println("Thread "+ threadname+ "exiting.");
    }
    public void start(){
        System.out.println(threadname + "Started");
        if(thread==null){
            thread=new Thread(this, threadname);
            thread.start();
        }
    }
}

public class TestDemo {
    public static void main(String[] args) {
        RunnableDemo runnableDemo=new RunnableDemo("thrd1");
        runnableDemo.start();

        RunnableDemo runnableDemo1=new RunnableDemo("thrd2");
        runnableDemo1.start();
    }
}