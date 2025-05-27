package org.lld.observerPattern;

import org.lld.observerPattern.observable.IphoneObservalbelImpl;
import org.lld.observerPattern.observer.EmailAlertImpl;
import org.lld.observerPattern.observer.MobileAlertobserver;
import org.lld.observerPattern.observer.NotificationAlertObserver;

public class store {
    public static void main(String[] args) {
        IphoneObservalbelImpl iphoneObservalbel = new IphoneObservalbelImpl();
        NotificationAlertObserver observer1 = new EmailAlertImpl("abc@gmail.com", iphoneObservalbel);
        NotificationAlertObserver observer2 = new EmailAlertImpl("xyz@gmail.com", iphoneObservalbel);
        NotificationAlertObserver observer3 = new MobileAlertobserver("lmn_username",iphoneObservalbel);

        iphoneObservalbel.add(observer1);
        iphoneObservalbel.add(observer2);
        iphoneObservalbel.add(observer3);

        iphoneObservalbel.setStockCount(10);
    }
}
