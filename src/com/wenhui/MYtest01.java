package com.wenhui;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MYtest01 {


    public static void main(String[] args) {
        Object o = new Object();
        Object o1 = new Object();
        new Thread(()->{
            synchronized (o){
                System.out.println("获得O锁，并期望获得O1锁");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (o1){
                    System.out.println("o锁成功获得o1锁");
                }
            }
        }).start();

        new Thread(()->{
            synchronized (o1){
                System.out.println("获得O1锁，并期望获得O锁");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (o){
                    System.out.println("o1锁成功获得o锁");
                }
            }
        }).start();
    }
}

class MySoure  {


    Integer num = 1;
    Integer num2 = 2;
    private Lock lock = new ReentrantLock();

    public void lockNum() throws InterruptedException {
//        try {
//            lock.lock();
//            num = 10;
//            Thread.sleep(20000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } finally {
//            lock.unlock();
//        }
        synchronized (num2){
            Thread.sleep(20000);
        }
    }

    public void lockNum2() throws InterruptedException {
//        try {
//            lock.lock();
//            num2 = 20;
//            Thread.sleep(20000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } finally {
//            lock.unlock();
//        }
        synchronized (num){
            Thread.sleep(20000);
        }
    }

}
