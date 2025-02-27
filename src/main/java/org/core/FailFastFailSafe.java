package org.core;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class FailFastFailSafe {
    public static void main(String[] args) {
//        failFastIterator();
        failSafeIterator();
    }

    public static void failSafeIterator(){
        String[] data = {"Tomcat", "Jetty", "JBoss"};
        CopyOnWriteArrayList<String> servers = new CopyOnWriteArrayList<>(data);
        /**Here Iterator is copy of ArrayList It will copy that collection thats wy it is avoid the exception, Drawback:Extra memory consumtion*/

        Iterator<String> iterator = servers.iterator();
        while (iterator.hasNext()){
            String server= iterator.next();
            System.out.println(server);
            if(server.equals("Tomcat")){
                servers.add("Jetty");
            }
        }
    }
    public static void failFastIterator(){
        ArrayList<String> servers = new ArrayList<>();
        servers.add("Tomcat");
        servers.add("Jetty");

        Iterator<String> iterator = servers.iterator();
        while (iterator.hasNext()){
            String server = iterator.next();
            /**It wil cannot modify the collection while iterating gives ConcurrentModificationException*/
//            servers.add("Jetty");
            System.out.println(server);
        }
    }
}
