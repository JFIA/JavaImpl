package com.rafel.DesignPatterns.adapter.instanceAdapter;

public class Main {

    public static void main(String[] args) {
        A a=new Adapter(new B());

        a.eat();
        a.work();
        a.sleep();
    }
}
