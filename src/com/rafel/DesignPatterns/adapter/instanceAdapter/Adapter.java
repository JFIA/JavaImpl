package com.rafel.DesignPatterns.adapter.instanceAdapter;
/***
 * 对象适配器不通过继承了，而是通过持有目标类的实例来解决兼容性的问题。
 */
public class Adapter implements A {

    private B b;

    public Adapter(B b){
        this.b=b;
    }

    @Override
    public void work() {
        b.work();

    }
    @Override
    public void eat() {

    }

    @Override
    public void sleep() {

    }
}
