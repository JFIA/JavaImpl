package com.rafel.DesignPatterns.template;

/***
 * 如果多个类中存在相似的算法或行为逻辑，将他们提取到模板方法类中实现，然后让子类根据需要是要自定义逻辑
 */

public abstract class Vehicle {
    String s;

    public Vehicle(String s) {
        this.s = s;
    }

    public void drive() {
        System.out.println(s + "ready to drive");
        startEngine();// 启动引擎
        putIntoGear();// 刹车
        looseHandBrake();// 手刹
        reStart();// 继续启动
    }

    private void looseHandBrake() {
        System.out.println(s + "手刹");
    }

    private void startEngine() {
        System.out.println(s + "启动引擎");
    }

    public abstract void putIntoGear();

    public void reStart() {
        System.out.println(s + "重启");
    }

}
