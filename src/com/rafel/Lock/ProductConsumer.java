package com.rafel.Lock;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ProductConsumer {
    private int size = 3;
    private Queue queue = new LinkedList();
    private ReentrantLock lock = new ReentrantLock();

    private Condition isEmpty = lock.newCondition();
    private Condition isFull = lock.newCondition();

    class Product implements Runnable {
        public void put(Object o) throws InterruptedException {
            while (true) {
                lock.lock();
                try {
                    /***
                     为什么不用if?
                     用 while 做检查，当第一个消费者被唤醒得到锁并移除数据之后，
                     第二个线程在执行 remove 前仍会进行 while 检查，发现此时依然满足 queue.size() == 0 的条件，
                     就会继续执行 await 方法，避免了获取的数据为 null 或抛出异常的情况。
                     ***/
                    while (queue.size() == size) {

                        System.out.println("当前队列满");
                        isFull.await();
                    }

                    queue.add(o);
                    System.out.println("put " + o);
                    isEmpty.signalAll();
                    Thread.sleep(5);

                } finally {
                    lock.unlock();
                }
            }
        }

        @Override
        public void run() {
            try {
                put("a");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    class Consumer implements Runnable {
        public void get() throws InterruptedException {
            while (true) {
                lock.lock();
                try {
                    while (queue.isEmpty()) {

                        System.out.println("当前队列为空");
                        isEmpty.await();
                    }

                    Object o = queue.remove();
                    System.out.println("get " + o);
                    isFull.signalAll();

                } finally {
                    lock.unlock();
                }
            }
        }

        @Override
        public void run() {
            try {
                get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        ProductConsumer p = new ProductConsumer();

        Thread thread = new Thread(p.new Product());
        Thread thread1 = new Thread(p.new Consumer());

        thread.start();
        thread1.start();

    }
}
