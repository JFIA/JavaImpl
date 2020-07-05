package com.rafel.DesignPatterns.template;

public class Main {

    public static void main(String[] args) {
        Vehicle at=new AT("自动挡");
        Vehicle mt=new MT("手动挡");

        at.drive();
        mt.drive();
    }

}
