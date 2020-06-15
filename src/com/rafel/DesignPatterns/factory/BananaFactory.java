package com.rafel.DesignPatterns.factory;

public class BananaFactory implements Factory {
    @Override
    public Fruit get() {
        return new Banana();
    }
}
