package com.wenhui;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MYYest02 {

    public void lock() {
        final Lock lock1 = new ReentrantLock();
        final Lock lock2 = new ReentrantLock();
        Executor executor = Executors.newFixedThreadPool(2);
        executor.execute(new Runnable() {
            @Override
            public void run() {
                lock1.lock();//获取锁1
                try {
                    Thread.sleep(1000);//等待线程2获取锁2
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                lock2.lock();//此时 线程2 已经获取锁2  故等待线程2 释放锁

                lock2.unlock();
                lock1.unlock();
            }
        });
        executor.execute(new Runnable() {
            @Override
            public void run() {
                lock2.lock();//线程2获取锁2
                lock1.lock();//此时 线程1 已经获取锁1  等待线程1 释放

                lock1.unlock();
                lock2.unlock();
            }
        });


    }

    public static void main(String[] args) {
        new MYYest02().lock();
    }
}
