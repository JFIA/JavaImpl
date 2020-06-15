package com.rafel.DesignPatterns.factory;

public class Main {

    public static void main(String[] args) {

        Fruit apple = new AppleFactory().get();
        Fruit banana = new BananaFactory().get();

        apple.eat();
        banana.eat();

    }
}
