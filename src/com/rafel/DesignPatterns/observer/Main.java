package com.rafel.DesignPatterns.observer;

public class Main {

    public static void main(String[] args) {
        Observer watcher1=new Watcher();
        Observer watcher2=new Watcher();
        Observer watcher3=new Watcher();

        Observered girl=new Watched();

        girl.addObs(watcher1);
        girl.addObs(watcher2);
        girl.addObs(watcher3);

        girl.removeObs(watcher1);

        girl.notifyObs("topic");
    }
}
