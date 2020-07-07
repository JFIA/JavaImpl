package com.rafel.DesignPatterns.strategy;

public class Banana implements Fruit {
    @Override
    public void eat() {
        System.out.println("this is a banana");
    }

    @Override
    public void product() {
        System.out.println("get a banana");
    }
}
