package com.rafel.DesignPatterns.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class DynamicProxy implements InvocationHandler {

    private Object object;

    public DynamicProxy(Object o) {
        this.object = o;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("动态代理买房前准备");
        Object result = method.invoke(object, args);
        System.out.println("动态代理买房后装修");
        return result;
    }
}
