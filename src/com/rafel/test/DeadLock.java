package com.rafel.test;

public class DeadLock implements Runnable{

    static Object o1 = new Object();

    static Object o2 = new Object();

    private boolean flag;

    public DeadLock(boolean flag){
        this.flag=flag;
    }

    @Override
    public void run() {

        if (flag){
            synchronized (o1){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("获得o1锁");
                synchronized (o2){
                    System.out.println("获得o2锁");
                }
            }
        }else {
            synchronized (o2){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("获得o2锁");
                synchronized (o1){
                    System.out.println("获得o1锁");
                }
            }
        }

    }

    public static void main(String[] args) {
        Thread t1=new Thread(new DeadLock(true));
        Thread t2=new Thread(new DeadLock(false));

        t1.start();
        t2.start();
    }
}
