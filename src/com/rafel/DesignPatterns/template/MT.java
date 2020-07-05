package com.rafel.DesignPatterns.template;

public class MT extends Vehicle {
    public MT(String s) {
        super(s);
    }

    @Override
    public void putIntoGear() {
        System.out.println(s + "踩刹车");
    }
}
