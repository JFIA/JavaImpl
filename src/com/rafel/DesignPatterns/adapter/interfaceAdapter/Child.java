package com.rafel.DesignPatterns.adapter.interfaceAdapter;

/**
 * 当我们要实现某一个接口中的部分方法时，就得用这个接口适配器去实现它。
 * 当我们要定义一个类用implements关键字实现一个接口时，我们必须实现接口中的所有方法。
 * 但如果这个类为抽象类，我们可以只实现接口中的部分方法就行了。
 * 所以说，当这个接口中有我们不想使用到的方法，此时，我们就需要借助“接口适配器”来实现它了。
 */
public class Child extends Adapter {

    public void eat(){
        System.out.println("eat");
    }

    public void walk(){
        System.out.println("walk");
    }
}
