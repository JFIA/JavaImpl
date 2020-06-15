package com.rafel.DesignPatterns.observer;

public class Watcher implements Observer {
    @Override
    public void update(String messages) {
        System.out.println(messages);
    }
}
