package com.rafel.Lock;

import com.sun.istack.internal.NotNull;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * CAS+自旋——简单实现自定义锁
 */

public class SpinLock implements Lock {

    /**
     * 锁持有线程, null表示锁未被任何线程持有
     */
    private final AtomicReference<Thread> owner = new AtomicReference<>();

    // owner锁持有个数
    private int holdCount;

    @Override
    public void lock() {

        final AtomicReference<Thread> owner = this.owner;

        final Thread thread = Thread.currentThread();

        // 当前线程已持有锁, 增加持有计数即可
        if (owner.get() == thread) {
            holdCount++;
            return;
        }

        // cas判断当前线程是否持有锁，null表示没有，否则自旋
        while (!owner.compareAndSet(null, thread)) {

        }

        holdCount = 1;

    }

    @Override
    public void lockInterruptibly() throws InterruptedException {

        final AtomicReference<Thread> owner = this.owner;
        final Thread current = Thread.currentThread();
        if (owner.get() == current) {
            ++holdCount;
            return;
        }
        while (!owner.compareAndSet(null, current)) {  // 响应中断
            if (current.isInterrupted()) {
                current.interrupt(); // 重设中断标志
                throw new InterruptedException();
            }
        }
        holdCount = 1;

    }

    @Override
    public boolean tryLock() {

        boolean locked=owner.compareAndSet(null, Thread.currentThread());

        if (locked){
            holdCount=1;
        }

        return locked;
    }

    @Override
    public boolean tryLock(long time, @NotNull TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override
    public void unlock() {
        final AtomicReference<Thread> owner = this.owner;

        final Thread current = Thread.currentThread();
        if(owner.get()!=current){
            throw new IllegalMonitorStateException();
        }

        if (--holdCount==0){
            owner.set(null);
        }

    }

    @NotNull
    @Override
    public Condition newCondition() {
        throw new UnsupportedOperationException();
    }
}
