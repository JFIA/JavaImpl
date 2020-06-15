package com.rafel.DesignPatterns.observer;


/***
 * 抽象被观察者接口
 * 声明了添加、删除、通知观察者方法
 *
 */
public interface Observered {

    public void addObs(Observer watcher);
    public void removeObs(Observer watcher);
    public void notifyObs(String str);
}
