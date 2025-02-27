package org.core;
public class FinalizeKeyExample {
    public static void main(String[] args) {
        FinalizeKeyExample user = new FinalizeKeyExample();
        System.out.println("Hashcode is : "+ user.hashCode());
        //making the object eligible for garbage collection
        user = null;
        System.gc();
        System.out.println("Is Demon Thread :: "+Thread.currentThread().isDaemon());

        //Adding short delay to allow GC to act
        try {
            Thread.sleep(1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("End of the GC ::");
    }
    //Defining the finalize method
    @Override protected void finalize(){
        System.out.println("Called the Finalize method ::");
    }
}

/**
 * Here Finalize method called by GC just before an object is removed from memory
 * */
