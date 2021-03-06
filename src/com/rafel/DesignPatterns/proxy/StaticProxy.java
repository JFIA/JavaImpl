package com.rafel.DesignPatterns.proxy;

/***
 * 优点：可以做到在符合开闭原则的情况下对目标对象进行功能扩展。
 *
 * 缺点：我们得为每一个服务都得创建代理类，工作量太大，不易管理。同时接口一旦发生改变，代理类也得相应修改。
 */
public class StaticProxy implements BuyHouse {
    private BuyHouse buyHouse;

    public StaticProxy(BuyHouse house){
        this.buyHouse=house;
    }
    @Override
    public void buyHouse() {
        System.out.println("静态代理买房前手续");
        buyHouse.buyHouse();
        System.out.println("静态代理买房后手续");
    }
}
