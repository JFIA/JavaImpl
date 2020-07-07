package com.rafel.DesignPatterns.strategy;

/***
 * 策略模式封装了实现某一种结果的所有算法逻辑，根据需要自行选择，注重过程。
 *
 * 与工厂模式区别：工厂模式主要是返回的接口实现类的实例化对象，最后返回的结果是接口实现类中的方法，
 * 而策略模式是在实例化策略模式的时候已经创建好了，我们可以再策略模式中随意的拼接重写方法，
 * 而工厂模式是不管方法的拼接这些的，他只关注最后的结果，不注重过程，而策略模式注重的是过程。
 *
 * 如果需要先生产水果再吃，工厂模式需要三个方法，而策略模式只需要实现一个，并在该方法中拼接逻辑。
 *
 */
public class Main {
    public static void main(String[] args) {
        Strategy strategy=new Strategy(new Apple());
        strategy.howToEat();

        Strategy strategy1=new Strategy(new Banana());
        strategy1.howToEat();
    }
}
