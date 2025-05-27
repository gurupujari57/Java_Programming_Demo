package org.lld.observerPattern.observer;

import org.lld.observerPattern.observable.StocksObservable;

public class EmailAlertImpl implements NotificationAlertObserver{
    String emailId;
    StocksObservable stocksObservable;

    public EmailAlertImpl(String emailId, StocksObservable stocksObservable) {
        this.emailId = emailId;
        this.stocksObservable = stocksObservable;
    }

    @Override
    public void update() {
        sendEmail(emailId,"Product is ion stock hurry up!!");
    }
    public void sendEmail(String emailId, String msg){
        System.out.println("Mail sent to : "+emailId);
    }
}
