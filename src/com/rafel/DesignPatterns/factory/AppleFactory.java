package com.rafel.DesignPatterns.factory;

public class AppleFactory implements Factory {
    @Override
    public Fruit get() {
        return new Apple();
    }
}
