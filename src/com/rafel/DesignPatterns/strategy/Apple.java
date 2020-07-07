package com.rafel.DesignPatterns.strategy;

public class Apple implements Fruit {
    @Override
    public void eat() {
        System.out.println("this a apple");
    }

    @Override
    public void product() {
        System.out.println("get a apple");
    }
}
