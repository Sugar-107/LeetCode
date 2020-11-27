package com.wenhui;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Test09 {
    public static void main(String[] args) {
        Object o1 = new Object();
        Lock lo = new ReentrantLock();

        new Thread(()->{
        //    synchronized (o1){
            try {
                lo.tryLock(2000, TimeUnit.SECONDS);
                System.out.println("A锁着");
                Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                lo.unlock();
            }
                System.out.println("Aleve");
//            }
        }).start();

        new Thread(()->{
            synchronized (o1){
                System.out.println("B锁着");

                System.out.println("Bleve");
            }
        }).start();
    }
}
