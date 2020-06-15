package com.rafel.DesignPatterns.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * 观察者模式定义了一种一对多的依赖关系，让多个观察者对象同时监听某一个主题对象。
 * 这个主题对象在状态上发生变化时，会通知所有观察者对象，让它们能够自动更新自己。
 */
public class Watched implements Observered {

    // 存放观察者
    List<Observer> list=new ArrayList<>();

    @Override
    public void addObs(Observer watcher) {

        list.add(watcher);
    }

    @Override
    public void removeObs(Observer watcher) {
        list.remove(watcher);
    }

    @Override
    public void notifyObs(String str) {

        // 循环列表调用观察者，进行通知
        for (Observer watcher : list) {
            watcher.update(str);
        }
    }
}
