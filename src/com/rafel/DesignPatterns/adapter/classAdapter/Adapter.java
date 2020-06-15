package com.rafel.DesignPatterns.adapter.classAdapter;

/***
 * 当我们的目标接口是A接口（不可以访问其它接口），可是A接口中并没有我们想要的方法，
 * 而B类中却有我们想要使用的方法时，我们就可以用适配器，将B类中的方法扩展到A接口中。
 */
public class Adapter extends B implements A {
    @Override
    public void eat() {

    }

    @Override
    public void sleep() {

    }
}
