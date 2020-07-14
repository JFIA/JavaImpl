package com.rafel.DesignPatterns.proxy;

import java.lang.reflect.Proxy;

public class Main {

    public static void main(String[] args) {
        BuyHouse buyHouse = new BuyHouseImpl();
        StaticProxy staticProxy = new StaticProxy(buyHouse);
        staticProxy.buyHouse();

        BuyHouse proxyBuyHouse = (BuyHouse) Proxy.newProxyInstance(BuyHouse.class.getClassLoader(), new
                Class[]{BuyHouse.class}, new DynamicProxy(buyHouse));

        proxyBuyHouse.buyHouse();

    }
}
