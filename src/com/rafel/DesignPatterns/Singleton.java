package com.rafel.DesignPatterns;

public class Singleton {
    /***
     * 饿汉式 线程安全。类加载初始化实例。
     private static Singleton singleton=new Singleton();
     private Singleton(){

     }
     public static Singleton getInstance(){
     return singleton;
     }
     **/

    /***
     * 懒汉式 线程不安全，可能会产生多个对象，不是单例。
     private static Singleton singleton;
     private Singleton(){}

     public static Singleton getSingleton() {
     if(singleton==null) {
     singleton=new Singleton();
     return singleton;
     }
     return singleton;
     }
     **/

    /**
     * 加同步锁即可线程安全。
     * private static Singleton singleton;
     * private Singleton(){}
     * <p>
     * public static synchronized Singleton getSingleton() {
     * if(singleton==null) {
     * singleton=new Singleton();
     * return singleton;
     * }
     * return singleton;
     * }
     ***/

    /***
     *双重检验锁，线程安全，效率高。
    private static Singleton singleton;

    private Singleton() {
    }

    public static Singleton getSingleton() {
        if (singleton == null) {
            synchronized (Singleton.class) {
                if (singleton == null) {
                    singleton = new Singleton();
                }
            }
        }

        return singleton;
    }
     **/

    /***
     *
     * * 静态内部类，虽然Singleton被装载但是instance不一定被初始化，因为静态内部类没有被使用，
     * * 只有显式调用getInstance方法才会装载SingletonHolder类，实例化instance。
     */
    private static class SingletonHolder {
        private static final Singleton SINGLETON=new Singleton();
    }

    private Singleton(){}

    public static Singleton getInstance(){
        return SingletonHolder.SINGLETON;
    }

}
