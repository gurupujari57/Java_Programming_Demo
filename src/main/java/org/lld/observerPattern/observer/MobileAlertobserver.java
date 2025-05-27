package org.lld.observerPattern.observer;

import org.lld.observerPattern.observable.StocksObservable;

public class MobileAlertobserver implements NotificationAlertObserver{
    String username;
    StocksObservable stocksObservable;

    public MobileAlertobserver(String username, StocksObservable stocksObservable) {
        this.username = username;
        this.stocksObservable = stocksObservable;
    }

    @Override
    public void update() {
        sendmessage(username, "product is in stocks hurry up!!");
    }
    public void sendmessage(String username, String msg){
        System.out.println("msg sent to : "+username);
    }
}
