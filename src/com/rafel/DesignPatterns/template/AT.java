package com.rafel.DesignPatterns.template;

public class AT extends Vehicle {

    public AT(String s) {
        super(s);
    }

    @Override
    public void putIntoGear() {
        System.out.println(s + "踩刹车");
    }
}
